import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class curdoperationsclass {
    private static DatabaseConnectionChecker database = DatabaseConnectionChecker.getInstance();

    // Method to login a user
    public static boolean login(String email, String password) {
        String query = "SELECT COUNT(*) FROM Users WHERE email = ? AND password = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
             
            pst.setString(1, email);
            pst.setString(2, password);
            // Execute query to check if user exists
            int count = pst.executeUpdate(); // This will return the number of affected rows
            return count > 0; // Return true if a user is found
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }

    // Method to sign up a new user
    public static boolean signUp(String name, String email, String password) {
        String query = "INSERT INTO Users (name, email, password) VALUES (?, ?, ?)";
        try (Connection conn = database.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
             
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0; // Return true if the user was added successfully
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Return false if the operation failed
    }

    // Method to check if an email is already registered
    public static boolean emailExists(String email) {
        String query = "SELECT COUNT(*) FROM Users WHERE email = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
             
            pst.setString(1, email);
            // Execute query
            int count = pst.executeUpdate(); // This will return the number of affected rows
            return count > 0; // Return true if email exists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }
}
