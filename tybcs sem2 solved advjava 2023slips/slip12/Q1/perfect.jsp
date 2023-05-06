<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="isPerfect.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfect Number Checker</title>
</head>
<body>
    <form method="post">
        <label for="number">Enter a number:</label>
        <input type="number" name="number" id="number" required>
        <button type="submit">Check</button>
    </form>

    <% 
    if (request.getMethod().equals("POST")) {
        int number = Integer.parseInt(request.getParameter("number"));
        request.setAttribute("number", number);
        request.getRequestDispatcher("isPerfect.jsp").include(request, response);
    }
    %>
</body>
</html>
