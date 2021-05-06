import java.io.IOException;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddCategory")

public class AddCategory extends HttpServlet {

	
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
	
	
		String CategoryName = req.getParameter("CategoryName");
		
		HttpSession h = req.getSession();
		String databasename=h.getAttribute("databasename").toString();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databasename,"root","Harikesh3009@699");
			String db = "create table "+CategoryName+"(brand varchar(60),color varchar(60),instock varchar(60),price varchar(60))";
			
			Statement s = c.createStatement();
			s.execute(db);
			
				h.setAttribute("CategoryName",CategoryName);
				res.sendRedirect("addItems.jsp");
			
			
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	
	}
	
}