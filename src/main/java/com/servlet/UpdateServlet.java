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
 * Servlet implementation class UpdateServlet
 */
@WebServlet(urlPatterns = {"/update"}, name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			int userId = Integer.parseInt(request.getParameter("id").trim());
			String fName = request.getParameter("fname");
			String lName = request.getParameter("lname");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			//System.out.println(fName + " " + lName);
			
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			User user = s.get(User.class, userId);
			
			user.setFirstName(fName);
			user.setLastName(lName);
			user.setEmail(email);
			user.setPhone(phone);
			
			s.update(user);
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
