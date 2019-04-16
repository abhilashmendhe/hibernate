package test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Vote;
import beans.Voter;

public class Client {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Voter v = new Voter();
		v.setVid(111);
		v.setVname("abhilash");
		v.setVage(25);
		
		Vote v1 = new Vote();
		v1.setPname("congress");
		v1.setCdate(new Date());
		v1.setVoter(v);
		
		
		session.save(v);
		session.save(v1);
		session.beginTransaction().commit();
		sf.close();
	}
}
