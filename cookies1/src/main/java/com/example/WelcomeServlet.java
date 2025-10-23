package com.example;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class WelcomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false); // don't create a new one

        if (session != null) {
            String name = (String) session.getAttribute("username");
            if (name != null) {
                out.println("<h2>Welcome back, " + name + "!</h2>");
                out.println("<a href='logout'>Logout</a>");
            } else {
                out.println("<h2>No username found in session.</h2>");
            }
        } else {
            out.println("<h2>No active session found.</h2>");
            out.println("<a href='index.html'>Login again</a>");
        }
    }
}