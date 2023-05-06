<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%
int number = (int) request.getAttribute("number");
int sum = 1;
ArrayList<Integer> factors = new ArrayList<Integer>();

for (int i = 2; i <= number/2; i++) {
    if (number % i == 0) {
        factors.add(i);
        sum += i;
    }
}

if (number == sum) {
    out.println("<p>" + number + " is a perfect number.</p>");
    out.println("<p>" + number + " = 1 + ");
    for (int i = 0; i < factors.size(); i++) {
        out.print(factors.get(i));
        if (i != factors.size() - 1) {
            out.print(" + ");
        }
    }
    out.println("</p>");
} else {
    out.println("<p>" + number + " is not a perfect number.</p>");
}
%>
