import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CountServlet extends HttpServlet implements Servlet
{
	static int numreq=0;
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		String data=req.getParameter("txt1");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		Cookie []c=req.getCookies();	
		out.println("<html><body>");
		if(c!=null)
		{
			for(int i=0;i<c.length;i++)
			{
				String name=c[i].getName();
				String value=c[i].getValue();
				if(c[i].getValue().equals(data))
				{
					out.println("<h3>you are visiting "+numreq+" times</h3>");
					numreq++;
					return;
				}
				else
				{
					Cookie c1=new Cookie("hobby",data);
					c1.setMaxAge(6000);
					resp.addCookie(c1);
					out.println("<h4>Welcome </h4><h2>"+data+"</h2>");
				}
			}
		}
		else
		{
			Cookie c2=new Cookie("hobby",data);
			c2.setMaxAge(6000);
			resp.addCookie(c2);
			out.println("<h4>Welcome </h4><h2>"+data+"</h2>");
		}
		out.close();
	}
}