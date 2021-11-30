package com.Exerice.Sercices;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
		Product Products = session.get(Product.class, id);
		session.close();

		return Products;

	}

	public List<Product> findAll() {
		session.beginTransaction();
		List<Product> Products = session.createQuery("from Product").getResultList();
		session.close();

		return Products;

	}

	public List<Product> findBySellPrice(double sellprice) {
		Session s = hibernateUtils.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		List<Product> Products = s.createQuery("from Product p where p.sellprice > :sellprice and f.nom like 'A%''")
				.setParameter("sellprice", sellprice).list();
		s.close();

		return Products;

	}

	public List<Product> findProductEntre100Et1000() {
		session.beginTransaction();
		List<Product> Products = session.createQuery("from Product p where p.price between 1000 and 100000000").list();

		session.close();

		return Products;

	}

	public List<Object[]> findPriceByFamily() {
		session.beginTransaction();
		List<Object[]> Products = session
				.createQuery("select famille, sum(p.price), sum(p.sellprice), from Product p group by famille").list();

		session.close();

		return Products;
	}

	public List<Product> findFamilyProduct(String family) {
		Session s = hibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		List<Product> Products = s.createQuery("from Product p where  p.famille like :family")
				.setParameter("family", family).getResultList();

		t.commit();
		s.close();

		return Products;
	}

	public void save(Product p) {
		Session s = hibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();

		s.save(p);

		t.commit();
		s.close();

	}

	public int updateProductsByFamily(String family) {
		session.beginTransaction();

		int a = session.createQuery(
				"update Product set price = price + price *  0.1,  sellprice = sellprice + sellprice * 0.1  where  famille like :family")
				.setParameter("family", family).executeUpdate();

		session.getTransaction().commit();
		session.close();
		return a;

	}

	public int deleteProducts() {
		session.beginTransaction();
		int a = session.createQuery("delete from  Product where nom like 'm%'").executeUpdate();
		session.getTransaction().commit();
		session.close();
		return a;

	}

	public long NumberOfProducts() {
		session.beginTransaction();
		// long a = (long) s.createQuery("select count(p) from Product
		// p").uniqueResult();
		long a = (long) session.createQuery("select count(p) from Product p").getSingleResult();
		session.close();
		return a;

	}

}
