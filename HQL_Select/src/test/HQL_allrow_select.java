package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class HQL_allrow_select {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		String hql = "from Employee";
		Query q = session.createQuery(hql);
		List<Employee> list = q.list();
		
		for(Employee e:list)
		{
			System.out.println("ID: "+e.getId());
			System.out.println("Name: "+e.getName());
			System.out.println("Email: "+e.getEmail());
			System.out.println("Salary: "+e.getSalary());
			
		}
		//t.commit();
		session.close();
		sf.close();
	}
}
