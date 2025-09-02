
// JobDAO.java
import java.sql.*;
import java.util.*;

public class JobDAO {
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT id, title, salary, location FROM Jobs";
        
        try (Connection conn = DatabaseConnectionChecker.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                jobs.add(new Job(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("salary"),
                    rs.getString("location")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }
}