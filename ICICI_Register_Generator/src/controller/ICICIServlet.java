package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.ICICIBeans;

/**
 * Servlet implementation class ICICIServlet
 */

public class ICICIServlet extends HttpServlet {
	
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
		int phone = Integer.parseInt(req.getParameter("phone"));
		int balance = Integer.parseInt(req.getParameter("balance"));

		
		
		ICICIBeans ic = new ICICIBeans();
		ic.setName(name);
		ic.setEmail(email);
		ic.setPhone(phone);
		ic.setBalance(balance);
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		String ac = (String) session.save(ic);
		t.commit();
		session.close();
		resp.getWriter().println("ID="+ac);
		
	}
	
}
