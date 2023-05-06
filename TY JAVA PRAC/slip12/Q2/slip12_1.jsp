<%@ page language="java"%>

<html>
<head>

<title>Perfect Number Checker</title>
</head>
<body>
<font color="red">
    <h1>Perfect Number Checker</h1>
<%! int sum=0,i=1;%>
    <%
        int num = Integer.parseInt(request.getParameter("t1"));

        while(i<num )
         {
          if(num%i==0)
           {
          sum=sum+i;
         }
    i++;
        }
      if(sum==num)
 out.println(num+"is Perfect");
else
    out.println(num+"is not perfect");
        
      
    %>
         
  </font> 
</body>
</html>
