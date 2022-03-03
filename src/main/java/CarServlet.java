import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
public class CarServlet extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse res)throws ServletException,IOException
{
	String model=request.getParameter("model");
	String year=request.getParameter("year");
	String color=request.getParameter("color");
	String miles=request.getParameter("miles");
	String bidIncrement=request.getParameter("bidincrement");
	String bprice=request.getParameter("bprice");
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
	         String sql = "INSERT INTO public.car VALUES ('C000" + randomNum + "','" +color +"',"+ miles +"," +bprice + ",'"+ model + "',"+ year +")";
	         stmt.executeUpdate(sql);
	         System.out.println("Inserted records into the car table...");   
	         ServletContext servletContext = getServletContext();
	         RequestDispatcher requestDispatcher = servletContext
	         .getRequestDispatcher("/login");
	         requestDispatcher.forward(request, res);
	 } catch (SQLException e) {
         e.printStackTrace();
      }
}
}
