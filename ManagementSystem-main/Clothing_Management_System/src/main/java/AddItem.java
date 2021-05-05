
import java.io.IOException;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddItem")

public class AddItem extends HttpServlet {
	
	
	
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
	
		
		String BrandName=req.getParameter("BrandName");
		String Color=req.getParameter("Color");
		String instock=req.getParameter("instock");
		String Price=req.getParameter("Price");

		HttpSession h = req.getSession();
		String databasename=h.getAttribute("databasename").toString();
		String CategoryName=h.getAttribute("CategoryName").toString();
			
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databasename,"root","Harikesh3009@699");
			String sql = "insert into "+CategoryName+" values('"+BrandName+"',"+"'"+Color+"',"+"'"+instock+"'," +"'"+Price+"')";
			
			Statement s = c.createStatement();
			s.execute(sql);
			
			res.sendRedirect("addItems.jsp");
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	
	}
	
}


