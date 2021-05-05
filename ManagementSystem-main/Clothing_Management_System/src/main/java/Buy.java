import javax.servlet.http.HttpServlet;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trishul.IndividualItem.IndividualItem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.sql.*;
import java.util.ArrayList;

@WebServlet("/Buy")
public class Buy extends HttpServlet {
	
	ArrayList<String>arr=new ArrayList<String>();
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
				
		 try {
			 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 //Query for fetching all names and userid ( also database name of the agent ) from Agent table
			 
			 String db = "select name,userid from Agent";
			 
			//Creating connection to ClothingManagementSystem database that contains Agent and User tables
			 //for Log in
			 
			 Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClothingManagementSystem","root","Harikesh3009@699") ;
			 Statement s = c.createStatement();
			 ResultSet rs = s.executeQuery(db);
			 
//			 res.setContentType("text/html");
			 
			 while(rs.next())
			 { 
				String databasename = rs.getNString("userid");
				 
				arr.add(databasename);
				
			 }
			 
			 req.setAttribute("agentids", arr);
			 
			 RequestDispatcher rd = req.getRequestDispatcher("CustomerHome.jsp");
			 
			 rd.forward(req, res);
			 
			 
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		} catch (ServletException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	

}
