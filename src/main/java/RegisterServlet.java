import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class RegisterServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
PrintWriter out = res.getWriter();
req.getRequestDispatcher("/registration.html").include(req, res); 
out.close();
}}
