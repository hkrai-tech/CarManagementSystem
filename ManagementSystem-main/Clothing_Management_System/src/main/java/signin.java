import javax.servlet.http.HttpServlet;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;

import javax.servlet.annotation.WebServlet;

import java.sql.*;

@WebServlet("/signin")
public class signin extends HttpServlet{

	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String user=req.getParameter("user");
		String userid = req.getParameter("userid");
		
		
		
		try {
			DataBaseOperations dbo = new DataBaseOperations(fullname,email,password,user,userid);
			if(dbo.signin())
			{
				res.getWriter().print("Signed in Successfully");
				
			}
			else {
				
				res.getWriter().print("User already exists");
				
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
		
}
