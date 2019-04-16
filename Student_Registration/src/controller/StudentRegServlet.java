package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

/**
 * Servlet implementation class StudentRegServlet
 */

public class StudentRegServlet extends HttpServlet {

	Configuration cfg;
	SessionFactory sf;
	@Override
	public void init() throws ServletException {
			// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("resources/mysql.cfg.xml");
		sf = cfg.buildSessionFactory();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String marks = req.getParameter("marks");
		int m = Integer.parseInt(marks);
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Student st = new Student();
		st.setName(name);
		st.setEmail(email);
		st.setMarks(m);
		
		int pk = (int)session.save(st);
		
		t.commit();
		session.close();
		
		PrintWriter out = resp.getWriter();
		out.println("Reg sucess with id="+pk);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		sf.close();
	}
}
