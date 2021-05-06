
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
import com.trishul.*;
import com.trishul.IndividualItem.IndividualItem;


@WebServlet("/ShowItem")


public class ShowItem extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		ArrayList<IndividualItem>arr=new ArrayList<IndividualItem>();
		
		
		HttpSession h = req.getSession();
		String databasename;
	 //fetching databasename from session
		if(h.getAttribute("user").toString().equals("Customer"))
		{
			databasename=h.getAttribute("db").toString();
		}
		else {
			databasename=h.getAttribute("databasename").toString();
		}
		
		//fetching category from the form present in ShowCategories
		
		String category = req.getParameter("category").toString();
		
		h.setAttribute("Category", category);
		

		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connecting to the agents data base and taking out all values in a particular category table
			 String db = "select * from "+category;
			 Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databasename,"root","Harikesh3009@699") ;
			 Statement s = c.createStatement();
			 ResultSet rs = s.executeQuery(db);
			 
			 while(rs.next())
			 {
				 
				  			 
				 
				 arr.add(new IndividualItem(rs.getNString("brand"),rs.getNString("color"),rs.getNString("instock"),rs.getNString("price")));
				 

			 	
			 }
			 
			 req.setAttribute("data", arr);
			 
			
			 RequestDispatcher rd = req.getRequestDispatcher("ShowItems.jsp");
			 
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
