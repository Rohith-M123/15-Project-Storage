<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forward Result</title>
</head>
<body>
    <h2>Request Forwarding Example</h2>
    <p>Hello, <b><%= request.getAttribute("name") %></b>! Your request was forwarded successfully.</p>
    <a href="index.html">Back to Home</a>
</body>
</html>
