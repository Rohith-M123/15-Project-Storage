package com.example;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ForwardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        request.setAttribute("name", username);

        // Forward request to forward.jsp
        RequestDispatcher rd = request.getRequestDispatcher("forward.jsp");
        rd.forward(request, response);
    }
}
