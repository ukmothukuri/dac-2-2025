package in.cdac.ecomm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDBOps 
{
	private Connection con = null;
	
	public UserDBOps(Connection con) {
		this.con = con;
	}
	
	public boolean registerUser(String useremail, String username, 
			String usermobile, String userpassword) {
		int rowsUpdated;
		String query = "insert into user_details values(?,?,?,?)";
		try {
			PreparedStatement ptst = con.prepareStatement(query);
			ptst.setString(1, useremail);
			ptst.setString(2, username);
			ptst.setString(3, usermobile);
			ptst.setString(4, userpassword);
			
			rowsUpdated = ptst.executeUpdate();
			if(rowsUpdated != 1) {
				return false;
			}
			
		}catch(SQLException sql) 
		{
			sql.printStackTrace();
		}
		return true;
	}
	
	public boolean getUserDetails(String useremail, String userpassword) {
		String query = "select * from user_details where useremail=? "
				+ "and userpassword=?";
		try {
			PreparedStatement ptst = con.prepareStatement(query);
			ptst.setString(1, useremail);		
			ptst.setString(2, userpassword);
			
			ResultSet rs = ptst.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch(SQLException sql) 
		{
			sql.printStackTrace();
		}
		return false;
	}
}
