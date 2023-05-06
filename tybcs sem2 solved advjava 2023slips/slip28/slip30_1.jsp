<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
<body>
 <font color="red">
   <%! 
 String s1;
    %>
    <% 
s1=request.getParameter("t1");
StringBuffer br=new StringBuffer(s1);
  out.println("reverse string is   "+br.reverse());
   %>
 </font>
</body>
</html>