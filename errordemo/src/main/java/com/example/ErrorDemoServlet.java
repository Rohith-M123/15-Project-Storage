package com.example;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ErrorDemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // This will intentionally cause an error (divide by zero)
        int result = 10 / 0;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Result: " + result + "</h3>");
    }
}
