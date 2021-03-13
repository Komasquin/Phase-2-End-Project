package com.log;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.to.Client;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//these lines of code can be in a Model Class to use to open a session for multiple calls, 
			//dining philosophers problem would have to be solved to use it properly. 
			Configuration config = new Configuration().configure();
			config.addAnnotatedClass(com.to.Client.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			SessionFactory factory = config.buildSessionFactory(builder.build());
			Session session = factory.openSession();
			//---------------------------------------------------------------------------------------
			String password = request.getParameter("password");
			String username = request.getParameter("username");
			//these lines can also be made in the Model to allow for different query calls to respective methods
			CriteriaBuilder cr = session.getCriteriaBuilder();
			CriteriaQuery<Client> query = cr.createQuery(Client.class);
			Root<Client> root = query.from(Client.class);
			query.select(root).where(cr.equal(root.get("userName"), username));
			Query<Client> q = session.createQuery(query);
			Client client = q.getSingleResult();
			//--------------------------------------------------------------------------------------------------
			if(client.getPassword().equals(password)) {
				RequestDispatcher rd = request.getRequestDispatcher("Acct.jsp");
				rd.forward(request, response);
			}
			
			session.close();
			
		}catch(NoResultException e) {
			PrintWriter out = response.getWriter();
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			out.print("<center><span style='color:red'>Please try again: INVALID ENTRY</span></center>");
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
