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
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		//Student object
		Student st = new Student();
		st.setId(113);
		st.setName("Student");
		st.setEmail("sthmendhe@gmail.com");
		st.setAddress("n Nagar,Pune");
		
		//session.save(st);// save() can execute with out transaction boundary's
		//session.persist(st);//session can not execute with out transaction boundary's
		session.saveOrUpdate(st);
		t.commit(); // data will execute here
		session.close();
		sf.close();
		
		System.out.println("Data inserted!!!");
	}
}
