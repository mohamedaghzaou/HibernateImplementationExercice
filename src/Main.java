import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Exercice.Hibernate.hibernateUtils;
import com.Exercice.model.Client;

public class Main {

	public static void main(String[] args) {
		Session s = hibernateUtils.getSessionFactory().getCurrentSession(); 

		Client c = new Client(1,"mmm","mmmm","mmmm","mmmm");

		Transaction t= s.beginTransaction();
		
		List<Client> clients = s.createQuery("from Client").list();
		
		for(Client c1 : clients) {
			System.out.println(c1);
		}

		
		t.commit();
		s.close();


	}

}
