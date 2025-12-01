package in.cdac.ecomm.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.cdac.ecomm.pojo.Product;

public class ProductDBOps {
	private Connection con = null;
	
	public ProductDBOps(Connection con) {
		this.con = con;
	}
	
	public List<Product> getAllProducts() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Product> products = null;
		String query = "select * from product_details";
		try {
			
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			products = new ArrayList<Product>();
			
			while(rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setPrice(rs.getDouble(4));
				p.setManufacturedYear(rs.getInt(5));
				products.add(p);
			}
		}catch(Exception ee) {
			ee.printStackTrace();
		}
		finally {
			if(con != null) {				
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return products;
	}
}
