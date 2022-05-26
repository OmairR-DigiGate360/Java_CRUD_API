package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class SaveUserServlet
 */
@WebServlet(urlPatterns = {"/add"}, name = "SaveUserServlet")
public class SaveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			String id = request.getParameter("id");
			int number = Integer.parseInt(id);
			String fName = request.getParameter("fname");
			String lName = request.getParameter("lname");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			User user = new User(number,fName,lName,email,phone);
			
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			s.save(user);
			tx.commit();
			s.close();
			
			/*
			 * response.setContentType("text/json"); PrintWriter out = response.getWriter();
			 * out.println("<h1>Successful</h1>"); System.out.println(user.getId() + "\n" +
			 * user.getFirstName() + "\n" + user.getLastName() + "\n" + user.getEmail() +
			 * "\n" + user.getPhone());
			 */
			response.sendRedirect("list");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
