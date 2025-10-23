package com.example;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // Simple authentication logic (you can replace with DB check)
        if ("admin".equals(user) && "1234".equals(pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", user);
            response.sendRedirect("welcome");
        } else {
            out.println("<html><body>");
            out.println("<h3 style='color:red;'>Invalid username or password!</h3>");
            out.println("<a href='login.html'>Try again</a>");
            out.println("</body></html>");
        }
    }
}
