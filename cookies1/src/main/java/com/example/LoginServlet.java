package com.example;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        // Create or get existing session
        HttpSession session = request.getSession();
        session.setAttribute("username", name);

        // Optionally create a cookie
        Cookie cookie = new Cookie("username", name);
        cookie.setMaxAge(60 * 60); // 1 hour
        response.addCookie(cookie);

        out.println("<h3>Welcome, " + name + "!</h3>");
        out.println("<a href='welcome'>Go to Welcome Page</a>");
    }
}