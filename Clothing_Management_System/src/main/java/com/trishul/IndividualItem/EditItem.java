package com.trishul.IndividualItem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EditItem")

public class EditItem extends HttpServlet {

	
	public void doPost(HttpServletRequest req , HttpServletResponse res)  {
		
		String brand = req.getParameter("brand");
		String color = req.getParameter("color");
		String instock = req.getParameter("instock");
		String price=req.getParameter("price");
		
		HttpSession h = req.getSession();
		String databasename=h.getAttribute("databasename").toString();
		
		
		try {
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 String db ="update "+h.getAttribute("Category")+" set brand='"+brand+"',color='"+color+"',instock='"+instock+"',price='"+price+"' where brand ='"+brand+"'";
			 Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databasename,"root","Harikesh3009@699") ;
			 Statement s = c.createStatement();
			 s.execute(db);
			 res.sendRedirect("ShowItem?category="+h.getAttribute("Category"));
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 

		
		
	}

}
