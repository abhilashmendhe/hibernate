package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class HQL_column_select {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		String hql = "select name from Employee";
		Query q = session.createQuery(hql);
		List<String> list = q.list();
		for(String name:list)
		{
			System.out.println("Name: "+name);
		}
		//t.commit();
		session.close();
		sf.close();
	}
}
