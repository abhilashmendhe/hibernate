package controller;

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
		
		Student st1 = new Student(1, "a", "a@gamil.com", 10);
		Student st2 = new Student(2, "b", "b@gamil.com", 10);
		Student st3 = new Student(3, "c", "c@gamil.com", 10);
		Student st4 = new Student(4, "d", "d@gamil.com", 10);
		Student st5 = new Student(5, "e", "e@gamil.com", 10);
		Student st6 = new Student(6, "f", "f@gamil.com", 10);
		Student st7 = new Student(7, "g", "g@gamil.com", 10);
		Student st8 = new Student(8, "h", "h@gamil.com", 10);
		Student st9 = new Student(9, "i", "i@gamil.com", 10);
		Student st10 = new Student(10, "j", "j@gamil.com", 10);
		Student st11 = new Student(11, "k", "k@gamil.com", 10);
	
		session.save(st1);
		session.save(st2);
		session.save(st3);
		session.save(st4);
		session.save(st5);
		session.save(st6);
		session.save(st7);
		session.save(st8);
		session.save(st9);
		session.save(st10);
		session.save(st11);
		t.commit();
		session.close();
		sf.close();
	}
	
}
