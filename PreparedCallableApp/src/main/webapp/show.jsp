<%@ page import="java.sql.*" %>
<html>
<head><title>All Students</title></head>
<body>
    <h2>Student List (Using CallableStatement)</h2>
    <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "yourpassword");

            CallableStatement cs = con.prepareCall("{call getAllStudents()}");
            ResultSet rs = cs.executeQuery();

            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Dept</th></tr>");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt(1) + "</td>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            con.close();
        } catch (Exception e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        }
    %>
    <br><a href="index.jsp">Back</a>
</body>
</html>
