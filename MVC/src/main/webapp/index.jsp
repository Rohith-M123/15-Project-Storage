<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Simple MVC Example</title>
    <style>
        body { font-family: Arial; text-align: center; margin-top: 100px; background: #f7f7f7; }
        h1 { color: #333; }
    </style>
</head>
<body>
    <h1><%= request.getAttribute("msg") %></h1>
    <p>This message is passed from the model through the controller to the view.</p>
</body>
</html>
