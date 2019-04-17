package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client {

	public static void main(String args[])
	{
		Configuration cfs = new Configuration();
		cfs.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfs.buildSessionFactory();
		
		Session session = sf.openSession();
		Session session2 = sf.openSession();
		
		System.out.println("using first session");
		Student st = session.get(Student.class, 1);
		System.out.println(st.getName());
		System.out.println(st.getMarks());
		System.out.println("using second session");
		Student st1 = session2.get(Student.class, 1);
		System.out.println(st1.getName());
		System.out.println(st1.getMarks());
	}
}
