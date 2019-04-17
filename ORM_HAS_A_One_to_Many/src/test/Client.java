package test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Actor;
import beans.Movies;

public class Client {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Actor a = new Actor();
		a.setAid(1);
		a.setActorname("Aamir Khan");
		
		Movies m1 = new Movies();
		m1.setMid(1);
		m1.setMoviename("Lagan");
		
		Movies m2 = new Movies();
		m2.setMid(2);
		m2.setMoviename("Dangal");
		
		Set<Movies> se = new HashSet<Movies>();
		se.add(m1);
		se.add(m2);
		
		a.setMovies(se);
		
		session.save(m1);
		session.save(m2);
		session.save(a);
		
		t.commit();
		
	}
}
