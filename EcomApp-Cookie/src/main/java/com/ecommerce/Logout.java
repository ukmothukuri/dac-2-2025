package com.ecommerce;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Cookie[] cks = request.getCookies();
		if(request.getCookies() == null) {
			response.sendRedirect("./Login.html");
		}else 
		{
			for (Cookie c : cks) {
				if(c.getName().equals("user")) {
					c.setValue("");
					c.setMaxAge(0);
					System.out.println("You are logged out.");
					response.addCookie(c);
					break;
				}
			}
			
			response.sendRedirect("./Logout.html");
		}
		
		
	}

}
