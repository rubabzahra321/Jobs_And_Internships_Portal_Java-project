import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class adminpannel extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField jobIdField, jobTitleField, jobDescriptionField, jobLocationField, jobSalaryField;
    private JTextField internshipIdField, internshipTitleField, internshipDescriptionField, internshipLocationField, internshipStipendField;
    private JPanel mainPanel;
    private HashMap<Integer, String> jobMap = new HashMap<>();
    private HashMap<Integer, String> internshipMap = new HashMap<>();

    private static final Color LIGHT_GREEN = new Color(23, 133, 130);
    private static final Color BROWN = new Color(191, 161, 129);

    public adminpannel() {
        // Main panel with background image
        mainPanel = new JPanel() {
            Image backgroundImage = new ImageIcon("src\\picture.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                g.setColor(new Color(0, 0, 0, 185)); // Semi-transparent overlay
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        this.setPreferredSize(new Dimension(1280, 720));
        this.setLayout(null);
        mainPanel.setBounds(0, 0, 1280, 720);
        mainPanel.setLayout(null);

        // Title label
        JLabel titleLabel = new JLabel("ADMIN");
        titleLabel.setBounds(550, 50, 400, 30);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainPanel.add(titleLabel);

        // Login Section
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(440, 150, 400, 300);
        loginPanel.setBackground(new Color(191, 161, 129, 0));
        mainPanel.add(loginPanel);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 100, 30);
        emailLabel.setForeground(Color.WHITE);
        loginPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 50, 200, 30);
        loginPanel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        passwordLabel.setForeground(Color.WHITE);
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 30);
        loginPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);
        loginButton.setBackground(LIGHT_GREEN);
        loginButton.setForeground(Color.WHITE);
        loginPanel.add(loginButton);

        // Add action listener for login button
        loginButton.addActionListener(e -> {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            // Check credentials
            if (email.equals("admin@gmail.com") && password.equals("123")) {
                JOptionPane.showMessageDialog(adminpannel.this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                showAdminOptions(); // Show admin options after successful login
            } else {
                JOptionPane.showMessageDialog(adminpannel.this, "Invalid email or password. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add main panel to the main JPanel
        this.add(mainPanel);
    }

    private void showAdminOptions() {
        mainPanel.removeAll(); // Clear previous components
        mainPanel.repaint();

        // Title for Admin Options
        JLabel optionsLabel = new JLabel("Admin Options");
        optionsLabel.setBounds(550, 50, 400, 30);
        optionsLabel.setForeground(Color.WHITE);
        optionsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainPanel.add(optionsLabel);

        // Job Addition Section
        JLabel addJobLabel = new JLabel("Add Job:");
        addJobLabel.setBounds(50, 100, 100, 30);
        addJobLabel.setForeground(Color.WHITE);
        mainPanel.add(addJobLabel);

        JLabel jobTitleLabel = new JLabel("Title:");
        jobTitleLabel.setBounds(50, 140, 100, 30);
        jobTitleLabel.setForeground(Color.WHITE);
        mainPanel.add(jobTitleLabel);

        jobTitleField = new JTextField();
        jobTitleField.setBounds(150, 140, 200, 30);
        mainPanel.add(jobTitleField);

        JLabel jobDescriptionLabel = new JLabel("Description:");
        jobDescriptionLabel.setBounds(50, 180, 100, 30);
        jobDescriptionLabel.setForeground(Color.WHITE);
        mainPanel.add(jobDescriptionLabel);

        jobDescriptionField = new JTextField();
        jobDescriptionField.setBounds(150, 180, 200, 30);
        mainPanel.add(jobDescriptionField);

        JLabel jobLocationLabel = new JLabel("Location:");
        jobLocationLabel.setBounds(50, 220, 100, 30);
        jobLocationLabel.setForeground(Color.WHITE);
        mainPanel.add(jobLocationLabel);

        jobLocationField = new JTextField();
        jobLocationField.setBounds(150, 220, 200, 30);
        mainPanel.add(jobLocationField);

        JLabel jobSalaryLabel = new JLabel("Salary:");
        jobSalaryLabel.setBounds(50, 260, 100, 30);
        jobSalaryLabel.setForeground(Color.WHITE);
        mainPanel.add(jobSalaryLabel);

        jobSalaryField = new JTextField();
        jobSalaryField.setBounds(150, 260, 200, 30);
        mainPanel.add(jobSalaryField);

        JButton addJobButton = new JButton("Add Job");
        addJobButton.setBounds(150, 300, 100, 30);
        addJobButton.setBackground(LIGHT_GREEN);
        addJobButton.setForeground(Color.WHITE);
        addJobButton.addActionListener(e -> addJob());
        mainPanel.add(addJobButton);

        // Job Deletion Section
        JLabel deleteJobLabel = new JLabel("Delete Job ID:");
        deleteJobLabel.setBounds(50, 360, 100, 30);
        deleteJobLabel.setForeground(Color.WHITE);
        mainPanel.add(deleteJobLabel);

        jobIdField = new JTextField();
        jobIdField.setBounds(150, 360, 200, 30);
        mainPanel.add(jobIdField);

        JButton deleteJobButton = new JButton("Delete Job");
        deleteJobButton.setBounds(150, 400, 100, 30);
        deleteJobButton.setBackground(LIGHT_GREEN);
        deleteJobButton.setForeground(Color.WHITE);
        deleteJobButton.addActionListener(e -> deleteJob());
        mainPanel.add(deleteJobButton);

        // Internship Addition Section
        JLabel addInternshipLabel = new JLabel("Add Internship:");
        addInternshipLabel.setBounds(400, 100, 150, 30);
        addInternshipLabel.setForeground(Color.WHITE);
        mainPanel.add(addInternshipLabel);

        JLabel internshipTitleLabel = new JLabel("Title:");
        internshipTitleLabel.setBounds(400, 140, 100, 30);
        internshipTitleLabel.setForeground(Color.WHITE);
        mainPanel.add(internshipTitleLabel);

        internshipTitleField = new JTextField();
        internshipTitleField.setBounds(550, 140, 200, 30);
        mainPanel.add(internshipTitleField);

        JLabel internshipDescriptionLabel = new JLabel("Description:");
        internshipDescriptionLabel.setBounds(400, 180, 100, 30);
        internshipDescriptionLabel.setForeground(Color.WHITE);
        mainPanel.add(internshipDescriptionLabel);

        internshipDescriptionField = new JTextField();
        internshipDescriptionField.setBounds(550, 180, 200, 30);
        mainPanel.add(internshipDescriptionField);

        JLabel internshipLocationLabel = new JLabel("Location:");
        internshipLocationLabel.setBounds(400, 220, 100, 30);
        internshipLocationLabel.setForeground(Color.WHITE);
        mainPanel.add(internshipLocationLabel);

        internshipLocationField = new JTextField();
        internshipLocationField.setBounds(550, 220, 200, 30);
        mainPanel.add(internshipLocationField);

        JLabel internshipStipendLabel = new JLabel("Stipend:");
        internshipStipendLabel.setBounds(400, 260, 100, 30);
        internshipStipendLabel.setForeground(Color.WHITE);
        mainPanel.add(internshipStipendLabel);

        internshipStipendField = new JTextField();
        internshipStipendField.setBounds(550, 260, 200, 30);
        mainPanel.add(internshipStipendField);

        JButton addInternshipButton = new JButton("Add Internship");
        addInternshipButton.setBounds(550, 300, 150, 30);
        addInternshipButton.setBackground(LIGHT_GREEN);
        addInternshipButton.setForeground(Color.WHITE);
        addInternshipButton.addActionListener(e -> addInternship());
        mainPanel.add(addInternshipButton);

        // Internship Deletion Section
        JLabel deleteInternshipLabel = new JLabel("Delete Internship ID:");
        deleteInternshipLabel.setBounds(400, 360, 150, 30);
        deleteInternshipLabel.setForeground(Color.WHITE);
        mainPanel.add(deleteInternshipLabel);

        internshipIdField = new JTextField();
        internshipIdField.setBounds(550, 360, 200, 30);
        mainPanel.add(internshipIdField);

        JButton deleteInternshipButton = new JButton("Delete Internship");
        deleteInternshipButton.setBounds(550, 400, 150, 30);
        deleteInternshipButton.setBackground(LIGHT_GREEN);
        deleteInternshipButton.setForeground(Color.WHITE);
        deleteInternshipButton.addActionListener(e -> deleteInternship());
        mainPanel.add(deleteInternshipButton);

        // Add Log Out Button near bottom center of the panel (adjust position as needed)
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBounds(590, 600, 100, 30); // position it near bottom center
        logoutButton.setBackground(LIGHT_GREEN);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.addActionListener(e -> {
            // Open LOGIN window
            LOGIN loginWindow = new LOGIN();
            loginWindow.setVisible(true);
            // Close the admin panel window by disposing the JFrame containing this panel
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (topFrame != null) {
                topFrame.dispose();
            }
        });
        mainPanel.add(logoutButton);

        mainPanel.revalidate(); // Refresh the panel
        mainPanel.repaint();
    }

    private void addJob() {
        String title = jobTitleField.getText().trim();
        String description = jobDescriptionField.getText().trim();
        String location = jobLocationField.getText().trim();
        String salary = jobSalaryField.getText().trim();

        if (title.isEmpty() || description.isEmpty() || location.isEmpty() || salary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = DatabaseConnectionChecker.getInstance().getConnection()) {
            String sql = "INSERT INTO Jobs (title, description, location, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setString(3, location);
            statement.setString(4, salary);
            statement.executeUpdate();

            java.sql.ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                jobMap.put(id, title);
            }

            JOptionPane.showMessageDialog(this, "Job added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding job: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        jobTitleField.setText("");
        jobDescriptionField.setText("");
        jobLocationField.setText("");
        jobSalaryField.setText("");
    }

    private void deleteJob() {
        String jobId = jobIdField.getText().trim();

        if (jobId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Job ID must be provided.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = DatabaseConnectionChecker.getInstance().getConnection()) {
            int id = Integer.parseInt(jobId);
            String sql = "DELETE FROM Jobs WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                jobMap.remove(id);
                JOptionPane.showMessageDialog(this, "Job deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No job found with this ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting job: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Job ID format.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
        jobIdField.setText("");
    }

    private void addInternship() {
        String title = internshipTitleField.getText().trim();
        String description = internshipDescriptionField.getText().trim();
        String location = internshipLocationField.getText().trim();
        String stipend = internshipStipendField.getText().trim();

        if (title.isEmpty() || description.isEmpty() || location.isEmpty() || stipend.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = DatabaseConnectionChecker.getInstance().getConnection()) {
            String sql = "INSERT INTO Internships (title, description, location, stipend) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setString(3, location);
            statement.setString(4, stipend);
            statement.executeUpdate();

            java.sql.ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                internshipMap.put(id, title);
            }

            JOptionPane.showMessageDialog(this, "Internship added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding internship: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        internshipTitleField.setText("");
        internshipDescriptionField.setText("");
        internshipLocationField.setText("");
        internshipStipendField.setText("");
    }

    private void deleteInternship() {
        String internshipId = internshipIdField.getText().trim();

        if (internshipId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Internship ID must be provided.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = DatabaseConnectionChecker.getInstance().getConnection()) {
            int id = Integer.parseInt(internshipId);
            String sql = "DELETE FROM Internships WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                internshipMap.remove(id);
                JOptionPane.showMessageDialog(this, "Internship deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No internship found with this ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting internship: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Internship ID format.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
        internshipIdField.setText("");
    }
}
