package com.Exerice.Sercices;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.Exercice.Hibernate.hibernateUtils;
import com.Exercice.model.Product;

public class Servicies {

	private final Session session;
	private static Servicies servicies = null;

	private Servicies() {
		this.session = hibernateUtils.getSessionFactory().getCurrentSession();
	}

	public static Servicies getInstance() {
		if (servicies == null)
			return new Servicies();

		return servicies;
	}

	public Product findById(int id) {
		session.beginTransaction();
		Criteria c = session.createCriteria(Product.class);
		c.add(Restrictions.idEq(id));
		Product Product = (Product) c.uniqueResult();
		session.close();
		return Product;

	}

	public List<Product> findAll() {
		session.beginTransaction();
		Criteria c = session.createCriteria(Product.class);
		List<Product> Products = c.list();
		session.close();
		return Products;

	}

	public List<Product> findBySellPrice(double sellprice) {
		
		session.beginTransaction();
		Criteria c = session.createCriteria(Product.class);
		c.add(Restrictions.gt("sellprice", sellprice));
		c.add(Restrictions.like("nom", "A%"));
		List<Product> Products=c.list();
		session.close();
		
		return Products;

	}

	public List<Product> findProductEntre100Et1000() {
		session.beginTransaction();
		Criteria c = session.createCriteria(Product.class);
		c.add(Restrictions.between("price", 100, 1000));
		List<Product> Products=c.list();
		
		session.close();
		return Products;
	}

	public List<Object[]> findPriceByFamily() {
		session.beginTransaction();
		 CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> c = builder.createQuery(Object[].class);
        Root<Product> root = c.from(Product.class);
        c.multiselect(root.get("famille"), builder.sum(root.get("price")),builder.sum(root.get("sellprice")));
        c.groupBy(root.get("famille"));
        Query<Object[]> query = session.createQuery(c);
		
		List<Object[]> Products =query.getResultList();

		session.close();

		return Products;
	}

	public List<Product> findFamilyProduct(String family) {
		session.beginTransaction();
		Criteria c = session.createCriteria(Product.class);
		c.add(Restrictions.like("famille", family));
		List<Product> Products=c.list();
		session.close();

		return Products;
	}

	public void save(Product p) {
		
		session.beginTransaction();
		session.close();
		
		Session s = hibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();

		s.save(p);

		t.commit();
		s.close();

	}

	public int updateProductsByFamily(String family) {
		
		List<Product> products = findFamilyProduct(family);
		 Session session = hibernateUtils.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 CriteriaBuilder builder = session.getCriteriaBuilder();
		 CriteriaUpdate<Product> criteriaUpdate = null;
		 Root<Product> root = null;

		 for (Product product : products) {
			 criteriaUpdate = builder.createCriteriaUpdate(Product.class);
			  root = criteriaUpdate.from(Product.class);
			 criteriaUpdate.set("price", product.getPrice()* 1.1 );
			 criteriaUpdate.set("sellprice", product.getSellprice()* 1.1 );
			 criteriaUpdate.where(builder.equal(root.get("id"), product.getId()));
			 session.createQuery(criteriaUpdate).executeUpdate();


		}
		session.close();
		return products.size();

	}

	public int deleteProducts() {
		session.beginTransaction();
		 CriteriaBuilder builder = session.getCriteriaBuilder();
		 CriteriaDelete<Product> criteriaDelete =  builder.createCriteriaDelete(Product.class);
		 Root<Product> root = criteriaDelete.from(Product.class);
		 
		 criteriaDelete.where(builder.like(root.get("nom"), "m%"));
		 int a  = session.createQuery(criteriaDelete).executeUpdate();
		 session.getTransaction().commit();
		 session.close();
		 return a;

	}	
}
