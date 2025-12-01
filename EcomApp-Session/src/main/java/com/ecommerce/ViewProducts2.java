package com.ecommerce;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.pojo.Product;

/**
 * Servlet implementation class ViewProducts
 */
public class ViewProducts2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Product> products = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewProducts2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userEmail = null;
		String role = null;
		
		HttpSession session = request.getSession(false);
		
		
		if (session == null)
		{
			// out.println("Your session is expired or you need to login.");
			response.sendRedirect("./SessionExpired.html");
		} else 
		{
			System.out.println("Here is the session ID " + session.getId());
			userEmail = session.getAttribute("useremail").toString();
			role = session.getAttribute("role").toString();
			System.out.println("User Email is " + userEmail);
			System.out.println("User Role is " + role);

			loadProducts();

			out.println("<h1>List of Products</h1>");
			out.println("<table style='border: solid'>");
			out.println("<tr>");
			out.println("<th>ID</th> <th>Name</th> <th>Price</th> <th>Year of Maf</th>");
			out.println("</tr>");

			for (Product p : products) {
				out.println("<tr>");
				out.println("<td>" + p.getProductId() + "</td>");
				out.println("<td>" + p.getProductName() + "</td>");
				out.println("<td>" + p.getPrice() + "</td>");
				out.println("<td>" + p.getManufacturedYear() + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}
	}

	private void loadProducts() {
		products = new ArrayList<Product>();

		Product p1 = new Product();
		p1.setProductId(100);
		p1.setProductName("Samsung Mobile 12");
		p1.setDescription("Its a latest model");
		p1.setPrice(25000);
		p1.setManufacturedYear(2025);

		Product p2 = new Product();
		p2.setProductId(101);
		p2.setProductName("HP Laptop X-Series");
		p2.setDescription("Have a longer battery with bigger screen");
		p2.setPrice(75000);
		p2.setManufacturedYear(2024);

		products.add(p1);
		products.add(p2);

	}

}
