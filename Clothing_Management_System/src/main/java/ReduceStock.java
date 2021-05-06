
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.trishul.IndividualItem.IndividualItem;

@WebServlet("/ReduceStock")
public class ReduceStock extends HttpServlet {
	
	
	static int findDifference(LocalDate start_date,LocalDate end_date)
			{
				Period diff= Period.between(start_date,end_date);
				return diff.getDays();
			}

	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
	
		 
		String brandD = req.getParameter("brand");
		
		HttpSession h = req.getSession();
		
		
		
		String databasename = h.getAttribute("db").toString();
		
		String userdatabasename=h.getAttribute("userdatabasename").toString();
		
		String Category =  h.getAttribute("Category").toString();
		String d=req.getParameter("RentTime");
		int RentTime=1;
		
		LocalDate start_date = LocalDate.now();

		//LocalDateTime y=LocalDateTime.parse(d);
		LocalDate d1=LocalDate.parse(d);
		//LocalDate today = y.toLocalDate();

		LocalDate end_date=d1;


   
		 RentTime=findDifference(start_date, end_date); 
		
		try {
			String db = "select * from "+Category+" where brand = '"+brandD+"'";
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
			 
			
			 
			 
			
			 
			
			 
			 
			 
			 if(n>0)
			 {
				 n--; 
			 
			 
			 Statement st = c.createStatement();
			 String change = "update "+Category+" set instock = '"+String.valueOf(n)+"' where brand = '"+brandD+"'";
			 st.execute(change);
			 
			 
			 //updating earnings of the Agent
			 
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClothingManagementSystem","root","Harikesh3009@699") ;
			 Statement state = con.createStatement();
			 String fetch = "select earnings from Agent where userid = '"+databasename+"'";
			 
			 ResultSet r = state.executeQuery(fetch);
			 r.next();
			 
			 int currentearning = Integer.parseInt(r.getNString("earnings"));
			 
			 String update =String.valueOf((currentearning + (price*RentTime)));
			 
			 
			 Statement sta = con.createStatement();
			 String str = "update Agent set earnings = '"+update+"' where userid = '"+databasename+"'" ;
			 
			 sta.execute(str);
			 
			 Connection cd = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+userdatabasename,"root","Harikesh3009@699") ;
			 
			 Statement hk = cd.createStatement();
			 
			 String purchaser = "insert into purchased(brand,color,price,AgentName,CategoryName,RentTime) values('"+brand+"','"+color+"','"+price+"','"+databasename+"','"+Category+"','"+RentTime+"')";
			 
			 hk.execute(purchaser);
			
			 }
			 
			 
			 res.sendRedirect("Buy");
			 
			 
			 
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	
		 
		 
		
		
		
	}

}
