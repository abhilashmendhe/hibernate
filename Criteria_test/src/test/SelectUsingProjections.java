package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import beans.Employee;

public class SelectUsingProjections {

	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Criteria c = session.createCriteria(Employee.class);
		Projection p1 = Projections.property("name");
		Projection p2 = Projections.property("email");
		ProjectionList plist = Projections.projectionList();
		
		//c.setProjection(p);
		plist.add(p1);
		plist.add(p2);
		c.setProjection(plist);
//		List<String> list = c.list();
		List<Object[]> list = c.list();
		
		for(Object[] o:list)
		{
			System.out.println(o[0]+" "+o[1]);
		}
		
	}
}
