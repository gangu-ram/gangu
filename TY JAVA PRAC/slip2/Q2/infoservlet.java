import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class infoservlet extends HttpServlet 
{
   public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
{
res.setContentType("text/html");
  PrintWriter out=res.getWriter();
out.println("<html>");
out.println("<body>");
out.println("servlet context"+getServletContext().getServerInfo()+"<br>");
out.println("Server Name:"+req.getServerName()+"<br>");
out.println("Remote Address:"+req.getRemoteAddr()+ "<br>");
out.println("Remote user:"+req.getRemoteUser()+ "<br>");
out.println("Server port:"+req.getServerPort()+ "<br>");
out.println("Remote Host:"+req.getRemoteHost()+ "<br>");
out.println("Local Name:"+req.getLocalName()+ "<br>");

out.println("browser Information"+req.getHeader("User-Agent"));
out.println("OS Name:"+System.getProperty("os.name")+ "<br>");
out.println("</body>");
out.println("</html>");
   }
}

