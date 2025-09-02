
import java.sql.*;
import java.util.*;

public class InternshipDAO {
    public List<Internship> getAllInternships() {
        List<Internship> internships = new ArrayList<>();
        String sql = "SELECT id, title, stipend, location FROM Internships";

        try (Connection conn = DatabaseConnectionChecker.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                internships.add(new Internship(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("stipend"),
                    rs.getString("location")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return internships;
    }
}
