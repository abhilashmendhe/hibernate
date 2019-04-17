package test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Course;
import beans.Faculty;

public class Client {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Course c1 = new Course();
		c1.setCid(1);
		c1.setCname("scjp");
		c1.setFee(2000);
		Course c2 = new Course();
		c2.setCid(2);
		c2.setCname("struts");
		c2.setFee(4000);
		Course c3 = new Course();
		c3.setCid(3);
		c3.setCname("jdbc");
		c3.setFee(1000);
		Course c4 = new Course();
		c4.setCid(4);
		c4.setCname("hibernate");
		c4.setFee(3000);
		Set<Course> cset1 = new HashSet<Course>();
		cset1.add(c1);
		cset1.add(c2);
		
		Set<Course> cset2 = new HashSet<Course>();
		cset2.add(c3);
		cset2.add(c4);
		
		Faculty f1 = new Faculty();
		f1.setFid(1);
		f1.setFname("durga");
		f1.setYearex(10);
		f1.setCourse(cset1);
		
		Faculty f2 = new Faculty();
		f2.setFid(2);
		f2.setFname("Srikant");
		f2.setYearex(5);
		f2.setCourse(cset2);
		
		session.save(f1);
		session.save(f2);
		session.save(c1);
		session.save(c2);
		t.commit();
		session.close();
		sf.close();
		
		
	}
}
