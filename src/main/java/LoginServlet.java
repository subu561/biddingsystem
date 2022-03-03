import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class LoginServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
PrintWriter out = res.getWriter();
String uname=req.getParameter("username");
String password=req.getParameter("password");
String query = "select username,password from public.login where username='" + uname + "' AND password="
		+ "'" + password + "'";
try {
	Class.forName("org.postgresql.Driver");
} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
try(Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/biddingsystem", "postgres", "dbproject");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
        	    ResultSet.CONCUR_READ_ONLY);){
  ResultSet resultSet = stmt.executeQuery(query);
  resultSet.last();
  int size = resultSet.getRow();
  resultSet.beforeFirst();
  if(size > 0) {
	  if(uname.indexOf("subu") >= 0) {
		  req.getRequestDispatcher("/addCars.html").include(req, res); 
	  }else {
	      req.getRequestDispatcher("/list.html").include(req, res); 
	  }
	  out.close();
  }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}}
