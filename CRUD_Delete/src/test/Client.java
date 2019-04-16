package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session sss = sf.openSession();
		Transaction t = sss.beginTransaction();
		
		Student st = new Student();
		st.setId(111);
		sss.delete(st);
		t.commit();
		sss.close();
		sf.close();
		System.out.println("Record deleted successfully!!!");
	}
}
