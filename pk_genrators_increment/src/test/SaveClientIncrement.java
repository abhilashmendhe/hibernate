package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.BookMovie;

public class SaveClientIncrement {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		BookMovie bk = new BookMovie();
		
		bk.setMovie("pk");
		bk.setSeatno(43);
		bk.setShowtime("2pm");
		
		int pk = (Integer) session.save(bk);
		t.commit();
		session.close();
		sf.close();
		System.out.println("Inserted using assigned generators");
		
	}

	
}
