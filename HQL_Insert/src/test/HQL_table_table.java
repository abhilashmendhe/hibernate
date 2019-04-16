package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.OldStudent;

public class HQL_table_table {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
	
		String hql = "insert into NewStudent(id,name,email,address) select s.id,s.name,s.email,s.address from OldStudent s";
		
		Query q = session.createQuery(hql);
		int i = q.executeUpdate();
		System.out.println("Number of rows: "+i+" from old to new table dumped");
		session.close();
		sf.close();
	}
}
