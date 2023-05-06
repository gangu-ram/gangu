import java.sql.*;

public class TeacherDemo {
    public static void main(String[] args) {
        try {
            
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password = "password";
            Connection conn = DriverManager.getConnection(url, username, password);

            
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Teacher (TNo, TName, Subject) VALUES (?, ?, ?)");

            
            stmt.setInt(1, 1);
            stmt.setString(2, "John Doe");
            stmt.setString(3, "JAVA");
            stmt.executeUpdate();

            stmt.setInt(1, 2);
            stmt.setString(2, "Jane Doe");
            stmt.setString(3, "PYTHON");
            stmt.executeUpdate();

            stmt.setInt(1, 3);
            stmt.setString(2, "Bob Smith");
            stmt.setString(3, "JAVA");
            stmt.executeUpdate();

            stmt.setInt(1, 4);
            stmt.setString(2, "Alice Johnson");
            stmt.setString(3, "JAVA");
            stmt.executeUpdate();

            stmt.setInt(1, 5);
            stmt.setString(2, "Tom Williams");
            stmt.setString(3, "C++");
            stmt.executeUpdate();

            
            stmt = conn.prepareStatement("SELECT * FROM Teacher WHERE Subject = ?");

            
            stmt.setString(1, "JAVA");
            ResultSet rs = stmt.executeQuery();
            System.out.println("Details of teachers who are teaching \"JAVA\" subject:");
            while (rs.next()) {
                int tno = rs.getInt("TNo");
                String tname = rs.getString("TName");
                String subject = rs.getString("Subject");
                System.out.println(tno + "\t" + tname + "\t" + subject);
            }

            
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
