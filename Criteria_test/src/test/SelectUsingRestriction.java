package test;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import beans.Employee;

public class SelectUsingRestriction {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Criteria c = session.createCriteria(Employee.class);
		
		Criterion cr = Restrictions.eq("id", 111);
		//Criterion cr = Restrictions.gt("salary", 50000);
		c.add(cr);
		
		Employee emp = (Employee) c.uniqueResult();
		System.out.println(emp.getEmail());
	}
}
