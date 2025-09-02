
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactMessageDAO {
    private DatabaseConnectionChecker database;

    public ContactMessageDAO() {
        this.database = DatabaseConnectionChecker.getInstance();
    }

    // Method to insert a contact message into the database
    public boolean submitContactMessage(ContactMessage message) {
        String query = "INSERT INTO ContactMessages (name, email, message) VALUES (?, ?, ?)";
        try (Connection conn = database.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
             
            pst.setString(1, message.getName());
            pst.setString(2, message.getEmail());
            pst.setString(3, message.getMessage());
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0; // Return true if the message was submitted successfully
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if there was an error
        }
    }
}
