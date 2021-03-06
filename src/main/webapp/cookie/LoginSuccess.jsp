<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Login Success Page</title>
</head>
<body>
<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if (cookies !=null) {
        for (Cookie cookie : cookies) {
            System.out.println("- " + cookie.getName() + ":" + cookie.getValue());
            if (cookie.getName().equals("username"))
                userName = cookie.getValue();
                System.out.println("userName : " + userName);
        }
    }
    if (userName == null) response.sendRedirect("/cookie/LoginForm.html");
%>
<h3>Hi <%=userName %>, Login successful.</h3>
<br>
<form action="/cookie/logout" method="post">
    <input type="submit" value="Logout" >
</form>
</body>
</html>