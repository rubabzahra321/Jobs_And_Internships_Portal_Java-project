
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JobApplicationDAO {
    private DatabaseConnectionChecker database;

    public JobApplicationDAO() {
        this.database = DatabaseConnectionChecker.getInstance();
    }

    // Method to insert a job application into the database
    public boolean submitJobApplication(JobApplication application) {
        String query = "INSERT INTO JobApplications (user_name, user_email, job_id, cover_letter) VALUES (?, ?, ?, ?)";
        try (Connection conn = database.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
             
            pst.setString(1, application.getUserName());
            pst.setString(2, application.getUserEmail());
            pst.setInt(3, application.getJobId());
            pst.setString(4, application.getCoverLetter());
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0; // Return true if the application was submitted successfully
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if there was an error
        }
    }
}

