import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class jobPanel extends JPanel {
    private JPanel jobsPanel;
    private JPanel applyPanel;
    private JPanel jobsContainer;
    private JScrollPane scrollPane;

    public jobPanel() {
        // Set layout of this main panel to null
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1280, 720));

        // Main Jobs Panel with background
        jobsPanel = new JPanel() {
            Image backgroundImage = new ImageIcon("src\\picture.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                g.setColor(new Color(0, 0, 0, 195));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        jobsPanel.setLayout(null);
        jobsPanel.setBounds(0, 0, 1280, 720);
        jobsPanel.setOpaque(false);
        

        // Header Labels
        JLabel jobsLabel = new JLabel("ONLINE JOBS & INTERNSHIP PORTAL");
        jobsLabel.setBounds(360, 50, 600, 30);
        jobsLabel.setForeground(Color.WHITE);
        jobsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        jobsPanel.add(jobsLabel);

        JLabel titleJobs = new JLabel("FIND YOUR DREAM JOB TODAY!");
        titleJobs.setBounds(480, 150, 600, 30);
        titleJobs.setForeground(new Color(191, 161, 129));
        titleJobs.setFont(new Font("Arial", Font.BOLD, 20));
        jobsPanel.add(titleJobs);

        // Jobs Container and Scroll
        jobsContainer = new JPanel(null);
        jobsContainer.setBackground(new Color(23, 133, 130));
        jobsContainer.setOpaque(true);

        scrollPane = new JScrollPane(jobsContainer);
        scrollPane.setBounds(150, 200, 950, 400);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBar(null);
        jobsPanel.add(scrollPane);

        // Apply Panel
        applyPanel = new JPanel();
        applyPanel.setLayout(null);
        applyPanel.setBackground(new Color(23, 133, 130));
        applyPanel.setBounds(300, 200, 700, 350);
        applyPanel.setVisible(false);

        JLabel titleLabel = new JLabel("Apply Now for Jobs");
        titleLabel.setBounds(250, 20, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.white);
        applyPanel.add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 70, 100, 30);
        nameLabel.setForeground(Color.white);
        applyPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(250, 70, 300, 30);
        applyPanel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, 110, 100, 30);
        emailLabel.setForeground(Color.white);
        applyPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(250, 110, 300, 30);
        applyPanel.add(emailField);

        JLabel jobLabel = new JLabel("Select Job:");
        jobLabel.setBounds(100, 150, 100, 30);
        jobLabel.setForeground(Color.white);
        applyPanel.add(jobLabel);

        // Load jobs from the database
        List<Job> jobs = loadJobsFromDatabase();
        String[] jobTitles = jobs.stream().map(Job::getTitle).toArray(String[]::new);
        Map<String, Integer> jobTitleToIdMap = new HashMap<>();
        for (Job job : jobs) {
            jobTitleToIdMap.put(job.getTitle(), job.getId());
        }

        JComboBox<String> jobComboBox = new JComboBox<>(jobTitles);
        jobComboBox.setBounds(250, 150, 300, 30);
        applyPanel.add(jobComboBox);

        JLabel coverLetterLabel = new JLabel("Cover Letter:");
        coverLetterLabel.setBounds(100, 190, 100, 30);
        coverLetterLabel.setForeground(Color.white);
        applyPanel.add(coverLetterLabel);

        JTextArea coverLetterArea = new JTextArea();
        coverLetterArea.setBounds(250, 190, 300, 100);
        coverLetterArea.setLineWrap(true);
        coverLetterArea.setWrapStyleWord(true);
        applyPanel.add(coverLetterArea);

        JButton submitButton = new JButton("Submit Application");
        submitButton.setBounds(150, 310, 200, 30);
        submitButton.setBackground(new Color(191, 161, 129));
        applyPanel.add(submitButton);

        JButton closeButton = new JButton("Return to Jobs");
        closeButton.setBounds(370, 310, 200, 30);
        closeButton.setBackground(new Color(191, 161, 129));
        applyPanel.add(closeButton);

        // Application submit
        submitButton.addActionListener(e -> {
            String userName = nameField.getText().trim();
            String userEmail = emailField.getText().trim();
            String selectedJobTitle = (String) jobComboBox.getSelectedItem();
            String coverLetter = coverLetterArea.getText().trim();

            if (userName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your name.");
                return;
            }
            if (userEmail.isEmpty() || !userEmail.contains("@")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
                return;
            }
            if (selectedJobTitle == null || !jobTitleToIdMap.containsKey(selectedJobTitle)) {
                JOptionPane.showMessageDialog(null, "Please select a job.");
                return;
            }
            if (coverLetter.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a cover letter.");
                return;
            }

            int jobId = jobTitleToIdMap.get(selectedJobTitle);
            JobApplication application = new JobApplication(userName, userEmail, jobId, coverLetter);
            JobApplicationDAO dao = new JobApplicationDAO();

            if (dao.submitJobApplication(application)) {
                JOptionPane.showMessageDialog(null, "Application submitted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Submission failed.");
            }

            nameField.setText("");
            emailField.setText("");
            coverLetterArea.setText("");
        });

        closeButton.addActionListener(e -> {
            applyPanel.setVisible(false);
            jobsContainer.setVisible(true);
            scrollPane.setVisible(true);

            // Bring jobsPanel back to front
            jobPanel.this.setComponentZOrder(jobsPanel, 0);
            jobPanel.this.setComponentZOrder(applyPanel, 1);

            jobPanel.this.revalidate();
            jobPanel.this.repaint();
        });

        // Add main panels to this panel
        this.add(jobsPanel);
        this.add(applyPanel);

        // Load jobs AFTER all components are initialized
        loadJobs();
    }

    private void loadJobs() {
        jobsContainer.removeAll();
        JobDAO jobDAO = new JobDAO();
        List<Job> jobs = jobDAO.getAllJobs();

        int y = 0;
        int spacing = 10;
        for (Job job : jobs) {
            JPanel jobPanel = createJobPanel(job);
            jobPanel.setBounds(10, y, 920, 130);
            jobsContainer.add(jobPanel);
            y += 130 + spacing;
        }

        // Set the container's size so the scroll pane can scroll properly
        jobsContainer.setPreferredSize(new Dimension(950, y));
        jobsContainer.revalidate();
        jobsContainer.repaint();
    }

    private JPanel createJobPanel(Job job) {
        JPanel jobPanel = new JPanel(null);
        jobPanel.setBackground(new Color(23, 133, 130));
        jobPanel.setOpaque(false);
        jobPanel.setBorder(new LineBorder(new Color(191, 161, 129), 4, true));
        jobPanel.setBorder(BorderFactory.createCompoundBorder(
            jobPanel.getBorder(),
            new EmptyBorder(10, 10, 10, 10)
        ));

        JLabel title = new JLabel(job.getTitle());
        title.setBounds(10, 10, 400, 20);
        title.setFont(new Font("Arial", Font.BOLD, 14));
        title.setForeground(Color.WHITE);
        jobPanel.add(title);

        JLabel salary = new JLabel("Salary: " + job.getSalary());
        salary.setBounds(10, 35, 400, 20);
        salary.setFont(new Font("Arial", Font.PLAIN, 12));
        salary.setForeground(Color.WHITE);
        jobPanel.add(salary);

        JLabel location = new JLabel("Location: " + job.getLocation());
        location.setBounds(10, 60, 400, 20);
        location.setFont(new Font("Arial", Font.PLAIN, 12));
        location.setForeground(Color.WHITE);
        jobPanel.add(location);

        JButton applyButton = createRoundedButton("Apply", 750, 90);
        jobPanel.add(applyButton);
        applyButton.addActionListener(e -> {
            applyPanel.setVisible(true);
            scrollPane.setVisible(false);
            jobsContainer.setVisible(false);
            jobPanel.this.setComponentZOrder(applyPanel, 0);
            jobPanel.this.setComponentZOrder(jobsPanel, 1);
            jobPanel.this.revalidate();
            jobPanel.this.repaint();
        });

        return jobPanel;
    }

    private JButton createRoundedButton(String text, int x, int y) {
        RoundedButton btn = new RoundedButton(text, 15);
        btn.setBounds(x, y, 85, 26);
        btn.setBackground(new Color(191, 161, 129));
        btn.setForeground(Color.black);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.setBorderColor(btn.getBackground());
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btn.setBackground(new Color(143, 120, 95));
                btn.setBorderColor(new Color(143, 120, 95));
                btn.setSize(90, 27);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(191, 161, 129));
                btn.setBorderColor(btn.getBackground());
                btn.setSize(85, 26);
            }
        });
        return btn;
    }

    private List<Job> loadJobsFromDatabase() {
        JobDAO jobDAO = new JobDAO();
        return jobDAO.getAllJobs();
    }
}
