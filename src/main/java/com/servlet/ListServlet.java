package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.google.gson.Gson;
import com.helper.FactoryProvider;
import com.userapi.module.User;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet(urlPatterns = {"/list"}, name = "ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try
		{
			Session s = FactoryProvider.getFactory().openSession();
			Query q = s.createQuery("from User");
			List<User> list = q.list();
			
			Gson gson = new Gson();
			String userJSON = gson.toJson(list);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out = response.getWriter();
			out.write(userJSON);
			out.close();
						
			s.close();
			
//			response.setContentType("text/json");
//			PrintWriter out = response.getWriter();
//			out.println("<h1>Successful</h1>");
//			System.out.println(user.getId() + "\n" + user.getFirstName() + "\n" + user.getLastName() + "\n" + user.getEmail() + "\n" + user.getPhone());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
