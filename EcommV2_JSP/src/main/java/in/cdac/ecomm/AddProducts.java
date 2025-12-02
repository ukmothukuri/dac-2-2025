package in.cdac.ecomm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import in.cdac.ecomm.db.DBUtil;
import in.cdac.ecomm.db.ProductDBOps;

/**
 * Servlet implementation class AddProducts
 */
public class AddProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(false);
		if(session != null) {
			request.getRequestDispatcher("./jsp/AddProducts.jsp").include(request, response);
		}else {
			response.sendRedirect("./jsp/SessionExpired.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(false);
		DBUtil db = new DBUtil();
		ProductDBOps dbops = null;
		if(session != null) {
			response.sendRedirect("./jsp/SessionExpired.jsp");
		}else {
			
			try {
				db = new DBUtil();
				dbops = new ProductDBOps(db.getDBConnection());
				//Write the saveproduct details code.
				
				//on successfull submission 
				response.sendRedirect("./jsp/AddProducts.jsp?msg=success");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
	
	}

}
