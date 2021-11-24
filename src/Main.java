import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Exercice.Hibernate.hibernateUtils;
import com.Exercice.model.Client;

public class Main {

	public static void main(String[] args) {
		Session s = hibernateUtils.getSessionFactory().getCurrentSession(); 

		Client c = new Client(1,"mmm","mmmm","mmmm","mmmm");

		Transaction t= s.beginTransaction();

		s.save(c);

		t.commit();
		s.close();


	}

}
