package in.cdac.ecomm;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import in.cdac.ecomm.db.DBUtil;
import in.cdac.ecomm.db.UserDBOps;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = "/userlogin")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatch = null;
		DBUtil db = null;
		UserDBOps dbops = null;
		String userName = null;
		String email = request.getParameter("useremail");
		String password = request.getParameter("userpassword");
		
		String errormsg = validateUserDetails(email, password);
		if(errormsg != null) {
			response.sendRedirect("./jsp/Login.jsp?msg="+errormsg);
		}	
		else {
			db = new DBUtil();
			try {
				dbops = new UserDBOps(db.getDBConnection());
				userName = dbops.verifyUser(email, password);
				if(userName != null) {
					HttpSession session = request.getSession(true);
					session.setAttribute("name", userName);
					
					request.getRequestDispatcher("./jsp/Welcome.jsp").forward(request, response);
					
				}else {
					response.sendRedirect("./jsp/Login.jsp?msg=invalidlogin");
				}
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	private String validateUserDetails(String email, String password) {
		
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
