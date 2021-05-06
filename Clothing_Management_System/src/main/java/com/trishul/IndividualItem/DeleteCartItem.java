package com.trishul.IndividualItem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteCartItem
 */
public class DeleteCartItem extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
		HttpSession session=req.getSession();
		String ItemName=req.getParameter("ItemName");
		String Category=req.getParameter("CategoryName");
		String databasename=(String) session.getAttribute("userdatabasename");
		
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 String db = "delete from purchased where PurchaseId ='"+req.getParameter("PurchaseId")+"'";
				 
				 Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databasename,"root","Harikesh3009@699") ;
				 Statement s = c.createStatement();
				 s.execute(db);
				 
				 res.sendRedirect("IncreaseStock?ItemName="+ItemName+"&AgentName="+req.getParameter("AgentName")+"&CategoryName="+Category+"&PurchaseId="+req.getParameter("PurschaseId"));
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
