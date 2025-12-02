package in.cdac.ecomm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private String dbURL = "jdbc:mysql://localhost:3306/ecomm_v2";
	private String username = "root";
	private String password = "root";
	private Connection con = null;
	
	public Connection getDBConnection() throws SQLException, ClassNotFoundException
	{				
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(dbURL, username, password);
		System.out.println("===="+con);
		return con;
	}
}
