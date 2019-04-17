package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Student;

/**
 * Servlet implementation class GetData
 */
public class GetData extends HttpServlet {

	SessionFactory sf;
	
	
	@Override
	public void init() throws ServletException {
			// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		sf=cfg.buildSessionFactory();
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		PrintWriter out = resp.getWriter();
		int fr = Integer.parseInt(req.getParameter("fr"));
		int mr = Integer.parseInt(req.getParameter("mr"));
		
		Query q = session.createQuery("from student100");
		q.setFirstResult(fr);
		q.setMaxResults(mr);
		
		List<Student> list = q.list();
		
		for(Student s:list)
		{
			out.println(s.getId()+" "+s.getName()+" "+s.getEmail()+" "+s.getMarks());
		}
		session.close();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		sf.close();
	}
}
