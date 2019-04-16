package test;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;
import beans.Employee;

public class Criteria_SelectAll {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Criteria c = session.createCriteria(Employee.class);
		
		List<Employee> list = c.list();
		
		for(Employee e: list)
		{
			System.out.println("Name: "+e.getName()+" -- Email: "+e.getEmail()+" -- Salary: "+e.getSalary());
		}
	}
}
