package com.trishul.IndividualItem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IncreaseStock
 */
public class IncreaseStock extends HttpServlet {
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		
		 
		String itemname = req.getParameter("ItemName");
		
		HttpSession h = req.getSession();
		
		
		
		String databasename = req.getParameter("AgentName");
		
		String userdatabasename=h.getAttribute("userdatabasename").toString();
		
		
		String Category = req.getParameter("CategoryName");
		
		try {
			String db = "select * from "+Category+" where brand = '"+itemname+"'";
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databasename,"root","Harikesh3009@699") ;
			 Statement s = c.createStatement();
			 ResultSet rs = s.executeQuery(db);
			 rs.next();
			 
			 int n = Integer.parseInt(rs.getNString("instock"));
			 int price = Integer.parseInt(rs.getNString("price"));
			 
			 String p = String.valueOf(price);
			 String brand = rs.getNString("brand");
			 
			 String color = rs.getNString("color");
			 
			
				 n++; 
			 
			//baki sab hgya sirf category khich kar lana hai 
			 Statement st = c.createStatement();
			 String change = "update "+Category+" set instock = '"+String.valueOf(n)+"' where brand = '"+itemname+"'";
			 st.execute(change);
			 
			 
			 //updating earnings of the Agent
			 
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClothingManagementSystem","root","Harikesh3009@699") ;
			 Statement state = con.createStatement();
			 String fetch = "select earnings from Agent where userid = '"+databasename+"'";
			 
			 ResultSet r = state.executeQuery(fetch);
			 r.next();
			 
			 int currentearning = Integer.parseInt(r.getNString("earnings"));
			 
			 String update =String.valueOf((currentearning - price));
			 
			 
			 Statement sta = con.createStatement();
			 String str = "update Agent set earnings = '"+update+"' where userid = '"+databasename+"'" ;
			 
			 sta.execute(str);
			 
			 
			 
			
			
			 
			 
			 res.sendRedirect("FetchCartItems");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	
		 
		 
		
		
		
	}


}
