import java.sql.*;

public class ProductTableDemo {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/products";

    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            
            Class.forName(JDBC_DRIVER);

            
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            
            System.out.println("Creating product table...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS product " +
                    "(pid INT PRIMARY KEY, " +
                    " pname VARCHAR(255), " +
                    " price DECIMAL(10,2))";
            stmt.executeUpdate(sql);

           
            System.out.println("Inserting records into product table...");
            sql = "INSERT INTO product (pid, pname, price) " +
                    "VALUES (101, 'Product 1', 100.00), " +
                    "(102, 'Product 2', 200.00), " +
                    "(103, 'Product 3', 300.00), " +
                    "(104, 'Product 4', 400.00), " +
                    "(105, 'Product 5', 500.00)";
            stmt.executeUpdate(sql);

            
            System.out.println("Displaying records from product table...");
            sql = "SELECT * FROM product";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                
                int pid = rs.getInt("pid");
                String pname = rs.getString("pname");
                double price = rs.getDouble("price");

                
                System.out.print("ID: " + pid);
                System.out.print(", Name: " + pname);
                System.out.println(", Price: " + price);
            }

            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
           
            se.printStackTrace();
        } catch (Exception e) {
            
            e.printStackTrace();
        } finally {
            
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } 
        System.out.println("Goodbye!");
    } 
} 
