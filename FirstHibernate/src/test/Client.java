package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client {

	public static void main(String args[])
	{
		Student st = new Student();
		st.setId("5");
		st.setName("xyz11");
		st.setEmail("xyz1212@gmail.com");
		
		//student object state in transient
		Configuration cg = new Configuration();
		cg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cg.buildSessionFactory();
		Session s = sf.openSession();
		s.save(st);
		
		//student object state in persistent
		
		s.beginTransaction().commit();
		
		//student obj will move database
		
		s.evict(st);
		
		//student obj will remove from persistent
		
		//then gc can collect student obj
	}
}
