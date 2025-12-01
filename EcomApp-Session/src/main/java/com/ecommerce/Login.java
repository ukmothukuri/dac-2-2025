package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login extends HttpServlet 
{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatch = null;
		String email = request.getParameter("useremail");
		String password = request.getParameter("userpassword");
		
		String errormsg = validateUserDetails(email, password);
		if(errormsg != null) {
			out.print(errormsg);
		}
		else {
					
			if(email.equals("admin@ecomm.in") && password.equals("admin@123"))
			{
				out.print("Welcome Admin");
				
				HttpSession session = request.getSession(true);
				session.setAttribute("useremail", email);
				session.setAttribute("role", "admin");
				
//				Cookie ck = new Cookie("user", email);
//				response.addCookie(ck);
				
				
				System.out.println("session ID "+session.getId());
				
				dispatch = request.getRequestDispatcher("/Welcome");
				dispatch.forward(request, response);
				
				
				
//				response.sendRedirect("./Welcome");
				
			}
			else if(email.equals("user@ecomm.in") && password.equals("user@123")) {
				out.print("Welcome User");
			
				HttpSession session = request.getSession(true);
				session.setAttribute("useremail", email);
				session.setAttribute("role", "user");
				
				
			}
			else {
//				dispatch = request.getRequestDispatcher("invalidlogin.html");
//				dispatch.include(request, response);
				
				response.sendRedirect("./invalidlogin.html");
			}
		}
	}
	
	public String validateUserDetails(String email, String password) {
		
		if(email.isEmpty())
		{
			return "Email cannot be empty";
		}
		else if(password.isEmpty()) {
			return "Password cannot be empty";
		}
		return null;		
	}

}
