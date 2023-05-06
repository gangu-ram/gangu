<%@ page language="java"%>

<html>
<head>

<title>Prime Number Checker</title>
</head>
<body>
<font color="red">
    <h1>Prime Number Checker</h1>
<%! int cnt=0,i=1;%>
    <%
        int num = Integer.parseInt(request.getParameter("t1"));

        while(i<=num )
         {
          if(num%i==0)
           {
          cnt++;
         }
    i++;
        }
      if(cnt==2)
 out.println(num+"is Prime");
else
    out.println(num+"is not Prime");
        
      
    %>
         
  </font> 
</body>
</html>
