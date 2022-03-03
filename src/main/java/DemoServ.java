import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class DemoServ extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
//String name=req.getParameter("name");
//pw.println("Welcome "+name);
//response.setContentType("text/html");
PrintWriter out = res.getWriter();
//out.println("Included HTML block:");
req.getRequestDispatcher("/addCars.html").include(req, res); 
out.close();
}}
