
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.sql.*;

@WebServlet("/Earnings")
public class Earnings extends HttpServlet {

		
		
		public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException 
		{
			HttpSession h = req.getSession();
			
			 try {
				 
				 
				 String userid = h.getAttribute("databasename").toString();
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 String db = "select earnings,name from Agent where userid = '"+userid+"'";
				 Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClothingManagementSystem","root","Harikesh3009@699") ;
				 Statement s = c.createStatement();
				 ResultSet rs = s.executeQuery(db);
				 
				 rs.next();
				 
				 String pesa = rs.getNString("earnings");
				 
				 String name = rs.getNString("name");
				 
				 
				 h.setAttribute("earnings", pesa);
				 h.setAttribute("name", name);
				 res.sendRedirect("home.jsp");
				 
				 
				 
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		
		}

}
