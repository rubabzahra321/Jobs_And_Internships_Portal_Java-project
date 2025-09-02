import java.sql.*;

public class DatabaseConnectionChecker {

	// Database credentials
	private static final String URL = "jdbc:mysql://localhost:3306/javadatabase";
	private static final String USER = "root";
	private static final String PASSWORD = "iwtlsql321RZ@paf";

	private static DatabaseConnectionChecker instance;
	private Connection connection;

	// Private constructor to prevent instantiation
	DatabaseConnectionChecker() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.err.println("MySQL JDBC driver not found!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Database connection failed!");
			e.printStackTrace();
		}
	}

	// Method to get the singleton instance
	public static DatabaseConnectionChecker getInstance() {
		if (instance == null) {
			instance = new DatabaseConnectionChecker();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public void close() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
}
