package com.ecommerce;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		String usermobile = request.getParameter("usermobile");
		String userpassword = request.getParameter("userpassword");
		
		System.out.println(username+"====="+useremail);		
		validatedDetails(username, useremail, usermobile, userpassword);
	}
	
	public String validatedDetails(String username, String useremail,
			String usermobile, String userpassword) 
	{
		String msg = null;
		String regEx = "a-zA-Z.";
		if(username.isEmpty()) {
			msg = "UserName cannot be empty.";
		}
		if(useremail.isEmpty()) {
			msg += "User Email cannot be empty.";
		}
		if(usermobile.isEmpty()) {
			msg += "User Mobile cannot be empty.";
		}
		
		if(userpassword.isEmpty()) {
			msg += "User Password cannot be empty.";
		}
		return msg;
	}
}