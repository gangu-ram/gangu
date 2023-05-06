<%@ page language="java" import="java.util.*" %>
<%
  String name,date;
  name=request.getParameter("a");
  Date d=new Date();
  date=d.toLocaleString();
  String s[]=date.split(" ");
  out.println(" Current date and time is:"+date);
  if(d.getHours() < 12 && s[4].equals("AM"))
    out.println("<br>Good Morning "+name);
  else
  if(d.getHours()==12 && s[4].equals("PM"))
    out.println("<br>Good Afternoon "+name);
  else
  if(d.getHours()<6 && s[4].equals("PM"))
    out.println("<br>Good Afternoon "+name);
  else
  if(d.getHours()>=6 && s[4].equals("PM"))
    out.println("<br>Good Evening "+name);
%>