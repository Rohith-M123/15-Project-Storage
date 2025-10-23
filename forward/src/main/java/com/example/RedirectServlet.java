package com.example;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class RedirectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        // Store username in session (optional)
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        // Redirect to another URL (back to index.html just for demo)
        response.sendRedirect("index.html");
    }
}
