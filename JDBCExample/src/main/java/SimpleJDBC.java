import java.sql.*;

public class SimpleJDBC {
    public static void main(String[] args) {
        try {
            // 1️⃣ Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2️⃣ Connect to Database (testdb)
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/testdb", "root", "root");

            // 3️⃣ Insert a record
            String insertQuery = "INSERT INTO students VALUES (3, 'Meena', 'AIML')";
            Statement st = con.createStatement();
            st.executeUpdate(insertQuery);
            System.out.println("Record inserted successfully!");

            // 4️⃣ Retrieve and display all records
            ResultSet rs = st.executeQuery("SELECT * FROM students");
            System.out.println("\nID | Name | Department");
            System.out.println("------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " +
                                   rs.getString(2) + " | " +
                                   rs.getString(3));
            }

            // 5️⃣ Close connection
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
