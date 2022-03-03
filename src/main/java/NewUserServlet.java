import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
public class NewUserServlet extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse res)throws ServletException,IOException
{
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String address=request.getParameter("address");
	String email=request.getParameter("email");
	String ssn=request.getParameter("SSN");
	String uname=request.getParameter("username");
	String password=request.getParameter("password");
	String user = request.getParameter("bidder") == null ? request.getParameter("seller") : request.getParameter("bidder");
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try(Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/biddingsystem", "postgres", "dbproject");
	         Statement stmt = conn.createStatement();
	      ) {		      
	         // Execute a query
	         System.out.println("Inserting records into the table...");
	         Random rand = new Random();
	         int randomNum = rand.nextInt((10 - 0) + 1) + 0;
	         String sql= new String();
	         if(user.equals("bidder")) {
	            sql = "INSERT INTO public.bidder VALUES ('B000" + randomNum + "'," +ssn +",'"+ name +"'," +phone + ",'"+ address + "','"+ email +"')";
	            System.out.println("Inserted records into the bidder table...");   
	         }else {
	        	sql = "INSERT INTO public.seller VALUES(" + ssn + ",'S000" + randomNum + "','" + name +"'," +phone + ",'"+ address + "','"+ email +"')";
	        	System.out.println("Inserted records into the seller table...");   
	         }
	         stmt.executeUpdate(sql);
	         sql = "INSERT INTO public.login VALUES ('" +uname +"','"+ password +"'," +ssn + ")";
	         stmt.executeUpdate(sql);
	         System.out.println("Inserted records into the login table...");
	         ServletContext servletContext = getServletContext();
	         RequestDispatcher requestDispatcher = servletContext
	         .getRequestDispatcher("/register");
	         requestDispatcher.forward(request, res);
	 } catch (SQLException e) {
         e.printStackTrace();
      }
}
}
