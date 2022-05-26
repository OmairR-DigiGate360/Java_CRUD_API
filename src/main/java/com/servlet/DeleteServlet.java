package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;
import com.userapi.module.User;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(urlPatterns = {"/delete"}, name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			int userId = Integer.parseInt(request.getParameter("id").trim());
			
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			User user = s.get(User.class, userId);
			s.delete(user);
			tx.commit();
			s.close();
			response.sendRedirect("list");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
