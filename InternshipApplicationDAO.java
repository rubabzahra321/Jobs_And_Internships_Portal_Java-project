
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InternshipApplicationDAO {
    private DatabaseConnectionChecker database;

    public InternshipApplicationDAO() {
        this.database = DatabaseConnectionChecker.getInstance();
    }

    // Method to insert an internship application into the database
    public boolean submitInternshipApplication(InternshipApplication application) {
        String query = "INSERT INTO InternshipApplications (user_name, user_email, internship_id, cover_letter) VALUES (?, ?, ?, ?)";
        try (Connection conn = database.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
             
            pst.setString(1, application.getUserName());
            pst.setString(2, application.getUserEmail());
            pst.setInt(3, application.getInternshipId());
            pst.setString(4, application.getCoverLetter());
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0; // Return true if the application was submitted successfully
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if there was an error
        }
    }
}
