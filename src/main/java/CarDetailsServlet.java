import javax.servlet.http.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.servlet.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
public class CarDetailsServlet extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse res)throws ServletException,IOException
{
	String carId=request.getParameter("carId");
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try(Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/biddingsystem", "postgres", "dbproject");
	         Statement stmt = conn.createStatement();
	      ) {	
		String query = "select * FROM public.car where CarID='"+carId + "'";
		ResultSet rs = stmt.executeQuery(query);
		String color = rs.getString("Color");
        int milesRun = rs.getInt("MilesRun");
        int price = rs.getInt("Base_price");
        String model = rs.getString("Model");
        int year = rs.getInt("Year");
        Document htmlFile = null;
        try {
            htmlFile = Jsoup.parse(new File("./webapp/WEB-INF/bidder.html"), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element div = htmlFile.getElementById("model");
        div.text(model);
	 } catch (SQLException e) {
         e.printStackTrace();
      }
}
}
