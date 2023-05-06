import java.sql.*;

public class ScrollableResultSetExample {
    
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
            
            
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            // Execute query to select all rows from Teacher table
            resultSet = statement.executeQuery("SELECT * FROM Teacher");
            
            // Move cursor to last row
            resultSet.last();
            
            // Display the last row
            System.out.println("Last row of Teacher table:");
            System.out.println("TID: " + resultSet.getInt("TID"));
            System.out.println("TName: " + resultSet.getString("TName"));
            System.out.println("Salary: " + resultSet.getDouble("Salary"));
            System.out.println();
            
            // Move cursor to first row
            resultSet.first();
            
            // Display all rows using while loop
            System.out.println("All rows of Teacher table:");
            while (resultSet.next()) {
                System.out.println("TID: " + resultSet.getInt("TID"));
                System.out.println("TName: " + resultSet.getString("TName"));
                System.out.println("Salary: " + resultSet.getDouble("Salary"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close ResultSet, statement, and connection
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
