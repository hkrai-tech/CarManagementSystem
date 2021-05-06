package com.trishul.IndividualItem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


	@WebServlet("/DeleteItem")
	public class DeleteItem extends HttpServlet {

		
		
		
			
			public void doGet(HttpServletRequest req , HttpServletResponse res) {
			
			HttpSession h = req.getSession();
			String databasename=h.getAttribute("databasename").toString();
			String itemname = req.getParameter("itemname");
				
				 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					 String db = "delete from "+ h.getAttribute("Category") +" where brand ='"+itemname+"'";
					 
					 Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databasename,"root","Harikesh3009@699") ;
					 Statement s = c.createStatement();
					 s.execute(db);
					 
					 res.sendRedirect("ShowItem?category="+h.getAttribute("Category"));
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
	
	
	
}
