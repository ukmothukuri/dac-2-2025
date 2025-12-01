package in.cdac.ecomm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import in.cdac.ecomm.db.DBUtil;
import in.cdac.ecomm.db.UserDBOps;

/**
 * Servlet implementation class UserRegistration
 */
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		String usermobile = request.getParameter("usermobile");
		String userpassword = request.getParameter("userpassword");
		String errorMessage = null;
		DBUtil db = null;
		UserDBOps dbops = null;
		boolean dbStatus = false;
		
		//System.out.println(username+"====="+useremail);		
		errorMessage = validatedDetails(username, useremail, usermobile, userpassword);
		
		// Save into the data to the database;
		if(errorMessage == null) 
		{
			try 
			{		
				db = new DBUtil();
				dbops = new UserDBOps(db.getDBConnection());
				dbStatus = dbops.registerUser(useremail, username, usermobile, userpassword);
				if(dbStatus) {
					response.sendRedirect("./jsp/Register.jsp?msg=success");
				}
				else {
					response.sendRedirect("./jsp/Register.jsp?msg=fail");
				}
			}
			catch(Exception ee) {
				ee.printStackTrace();				
			}			
		}
		else {
			response.sendRedirect("./jsp/Register.jsp?msg="+errorMessage);
		}
	}
	
	public String validatedDetails(String username, String useremail,
			String usermobile, String userpassword) 
	{
		String msg = null;
		String regEx = "a-zA-Z.";
		if(username.isEmpty()) {
			msg = "UserName cannot be empty.";
		}
		else if(useremail.isEmpty()) {
			msg = "User Email cannot be empty.";
		}
		else if(usermobile.isEmpty()) {
			msg = "User Mobile cannot be empty.";
		}		
		else if(userpassword.isEmpty()) {
			msg = "User Password cannot be empty.";
		}
		return msg;
	}

}
