package com.example;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

// A simple servlet example
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; // Prevents serialization warning

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Welcome to My First Servlet!</h1>");
        out.println("<p>This servlet is deployed successfully on Tomcat.</p>");
        out.println("</body></html>");
    }
}
