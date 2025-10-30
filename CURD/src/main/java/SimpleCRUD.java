import java.sql.*;
import java.util.Scanner;

public class SimpleCRUD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // 1️⃣ Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2️⃣ Connect to Database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "root");

            while (true) {
                System.out.println("\n=== SIMPLE CRUD MENU ===");
                System.out.println("1. Insert");
                System.out.println("2. Display");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                if (ch == 1) {
                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO students VALUES (?, ?, ?)");
                    System.out.print("Enter ID: ");
                    ps.setInt(1, sc.nextInt());
                    System.out.print("Enter Name: ");
                    ps.setString(2, sc.next());
                    System.out.print("Enter Dept: ");
                    ps.setString(3, sc.next());
                    ps.executeUpdate();
                    System.out.println("Record inserted!");
                }
                else if (ch == 2) {
                    ResultSet rs = con.createStatement()
                                      .executeQuery("SELECT * FROM students");
                    System.out.println("\nID | Name | Dept");
                    System.out.println("------------------");
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + " | " +
                                           rs.getString(2) + " | " +
                                           rs.getString(3));
                    }
                }
                else if (ch == 3) {
                    PreparedStatement ps = con.prepareStatement(
                        "UPDATE students SET name=? WHERE id=?");
                    System.out.print("Enter new name: ");
                    ps.setString(1, sc.next());
                    System.out.print("Enter ID: ");
                    ps.setInt(2, sc.nextInt());
                    ps.executeUpdate();
                    System.out.println("Record updated!");
                }
                else if (ch == 4) {
                    PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM students WHERE id=?");
                    System.out.print("Enter ID: ");
                    ps.setInt(1, sc.nextInt());
                    ps.executeUpdate();
                    System.out.println("Record deleted!");
                }
                else if (ch == 5) {
                    System.out.println("Exiting...");
                    break;
                }
                else {
                    System.out.println("Invalid choice!");
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        sc.close();
    }
}
