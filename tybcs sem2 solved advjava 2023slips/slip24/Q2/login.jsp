<%@ page language="java" %>
<% 
String user=request.getParameter("t1");
String pwd=request.getParameter("t2");
if(user.equals(pwd))
{
	 out.println("Login success");
}
else
	 out.println("Login not success");
%>