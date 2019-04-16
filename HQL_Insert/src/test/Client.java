package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import beans.*;
public class Client {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		OldStudent os1 = new OldStudent(111,"Abhilash", "abhilashmendhe@gmail.com", "Pune");
		OldStudent os2 = new OldStudent(112,"abc", "abc@gmail.com", "Mumbai");
		OldStudent os3 = new OldStudent(113,"lmn", "lmn@gmail.com", "Hongkong");
		OldStudent os4 = new OldStudent(114,"xyz", "xyz@gmail.com", "Japan");
		
		session.save(os1);
		session.save(os2);
		session.save(os3);
		session.save(os4);
		t.commit();
		session.close();
		sf.close();
	}
}
