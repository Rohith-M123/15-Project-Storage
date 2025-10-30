package com.example;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class TransactionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        int from = Integer.parseInt(req.getParameter("from"));
        int to = Integer.parseInt(req.getParameter("to"));
        double amount = Double.parseDouble(req.getParameter("amount"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/testdb", "root", "root");

            // Disable auto-commit
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE acc_no = ?");
            ps1.setDouble(1, amount);
            ps1.setInt(2, from);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE acc_no = ?");
            ps2.setDouble(1, amount);
            ps2.setInt(2, to);
            ps2.executeUpdate();

            // ✅ Commit both updates as one transaction
            con.commit();
            out.println("<h3 style='color:green;'>Transaction Successful!</h3>");

            con.close();
        } catch (Exception e) {
            try {
                // ❌ Rollback if any failure
                Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "root", "root");
                con.rollback();
            } catch (Exception ex) {
                out.println("<p>Rollback failed: " + ex.getMessage() + "</p>");
            }
            out.println("<h3 style='color:red;'>Transaction Failed: " + e.getMessage() + "</h3>");
        }
    }
}
