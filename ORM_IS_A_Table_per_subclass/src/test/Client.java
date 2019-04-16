package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.AEmployee;
import beans.HEmployee;
import beans.SEmployee;

public class Client {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		SEmployee se = new SEmployee(111, "abc", "abc@gmail.com", 50000, "hibernate");
		HEmployee he = new HEmployee(112, "lmn", "lmn@gmail.com", 30000, 10);
		AEmployee ae = new AEmployee(113, "ayz", "xyz@gmail.com", 100000, "srnagar");
		
		session.save(se);
		session.save(he);
		session.save(ae);
		t.commit();
		session.close();
		sf.close();
	}
}
