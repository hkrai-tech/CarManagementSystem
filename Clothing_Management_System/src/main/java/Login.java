import javax.servlet.http.HttpServlet;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;

import java.sql.*;

@WebServlet("/Login")
public class Login extends HttpServlet {

	//The doPost receives email and password and user type for example Agent or Customer
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException 
	{
		//fetching the values from the form received in req object
		
		String email = req.getParameter("email");
		
		String password = req.getParameter("password");
		
		String user = req.getParameter("user");

			try {
				
				// creating DataBaseOperation class's object using a Constructor that is made for users who try to login
				//check out DataBaseOperation class for more info
				
				DataBaseOperations dbo = new DataBaseOperations(email,password,user);
				
				//Now we check if the user exists in our database if not we call login page again
				
				if(dbo.isValidUser())
				{
					HttpSession h = req.getSession();
					
					//setting email in the session
					
					h.setAttribute("email", email);
					
					//checking if user is Agent or Customer
					
					if(user.equals("Agent"))
					{
					//if user is Agent then we'll need to access his database several times do setting it up in session
					
					h.setAttribute("databasename", dbo.DataBaseName);
					h.setAttribute("name", dbo.fullname);
					h.setAttribute("user", "Agent");
					//now we send the Agent to his dash-board
					
					res.sendRedirect("Earnings");
					}
					
					//now if user is Customer we dont have a database for him he will only see databases of agents
					//so we set up user type i.e Customer in session because we need to process different things for this type
					//users
					
					else {
						h.setAttribute("userdatabasename", dbo.DataBaseName);
						h.setAttribute("name", dbo.fullname);
					h.setAttribute("user", "Customer");
							
					//sending the Customer to the home page
					
					res.sendRedirect("Buy");
					}
					
				}
				
				else {
					
					res.sendRedirect("login.jsp");
					
				}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		
		
		
	}
	
}
