<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple JSP Page</title>
</head>
<body>
    <h2>Welcome to JSP!</h2>
    <p>Hello, this is a simple JSP page.</p>

    <% 
        String name = "Rohith";
        out.println("<p>Your name is: " + name + "</p>");
    %>
</body>
</html>
