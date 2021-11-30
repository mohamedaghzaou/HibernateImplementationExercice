import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Exercice.Hibernate.hibernateUtils;
import com.Exercice.model.Client;
import com.Exercice.model.Product;
import com.Exerice.Sercices.Servicies;

public class Main {

	public static void main(String[] args) {

		Product a = Servicies.getInstance().findById(1);
		System.out.println(a);

	}

}
