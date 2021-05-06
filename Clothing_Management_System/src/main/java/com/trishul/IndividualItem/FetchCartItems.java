package com.trishul.IndividualItem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FetchCartItems")
public class FetchCartItems extends HttpServlet {

	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException{
		
		HttpSession h = req.getSession();
		
		String userdatabasename = h.getAttribute("userdatabasename").toString();
		
		try {
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+userdatabasename,"root","Harikesh3009@699") ;
			 Statement s = c.createStatement();
			 String db = "select * from purchased";
			 
			 ResultSet rs = s.executeQuery(db);
			 
			 ArrayList<IndividualItem>arr=new ArrayList<IndividualItem>();
			 
			 while(rs.next())
			 {
				 arr.add(new IndividualItem(rs.getNString("brand"),rs.getNString("color"),rs.getNString("price"),rs.getNString("AgentName"),rs.getNString("CategoryName"),rs.getInt("PurchaseId"),rs.getInt("RentTime")));
			 }
			 
			 req.setAttribute("purchased", arr);
			 
			 RequestDispatcher rd = req.getRequestDispatcher("Cart.jsp");
			 
			 rd.forward(req, res);
			 
			 
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}


