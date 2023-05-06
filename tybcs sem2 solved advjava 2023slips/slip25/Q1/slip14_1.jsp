<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
<body>
 <font color="red">
   <%! int age;
   String name;
    %>
    <% 
name=request.getParameter("t1");
age=Integer.parseInt(request.getParameter("t2"));
    
     if(age>18)
      out.println(name+"elligible for voating");
   else
      out.println(name+"not elligible for voating");
    %>
 </font>
</body>
</html>