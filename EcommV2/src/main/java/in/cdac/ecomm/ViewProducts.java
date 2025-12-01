package in.cdac.ecomm;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import in.cdac.ecomm.db.DBUtil;
import in.cdac.ecomm.db.ProductDBOps;
import in.cdac.ecomm.pojo.Product;

/**
 * Servlet implementation class ViewProducts
 */
public class ViewProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBUtil dbops =  new DBUtil();
		try {
			ProductDBOps pdops = new ProductDBOps(dbops.getDBConnection());
			List<Product> products = pdops.getAllProducts();
			
			request.setAttribute("products", products);
			RequestDispatcher dispatch = request.getRequestDispatcher("./jsp/ViewProducts.jsp");
			dispatch.forward(request, response);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
