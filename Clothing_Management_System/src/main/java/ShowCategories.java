
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.trishul.IndividualItem.IndividualItem;

@WebServlet("/ShowCategories")

public class ShowCategories extends HttpServlet {

	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
			
		HttpSession h = req.getSession();
				
		//we need session to check whether user is agent or customer
		//if customer we fetch database name from the form present in
		//Buy servlet and setup database name in session
		//else we fetch data base name from the session itself that was created on the time of login
		
		String databasename;
		if(h.getAttribute("user").toString().equals("Customer"))
		{
			
			 databasename=req.getParameter("agentuserid");
			 h.setAttribute("db", databasename);
		}
		else {
			databasename=h.getAttribute("databasename").toString();
		}
		
		
		 try {
			 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 //geting all tables for a particular agent 
			 String db = "show tables";
			 
			 Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databasename,"root","Harikesh3009@699") ;
			 Statement s = c.createStatement();
			 ResultSet rs = s.executeQuery(db);
			 			 
			 ArrayList<String>arr=new ArrayList<String>();
			 
			 while(rs.next())
			 {
				 
				arr.add(rs.getNString("Tables_in_"+databasename));
				

			 }
			 

			 
			 req.setAttribute("arr", arr);
			
			 RequestDispatcher rd = req.getRequestDispatcher("MyCategories.jsp");
			 
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
