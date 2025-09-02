import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class internshipPanel extends JPanel {
    private JPanel internshipsPanel;
    private JPanel applyPanel;
    private JPanel internshipsContainer;
    private JScrollPane scrollPane;

    public internshipPanel() {
        // Set layout of this main panel to null
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1280, 720));

        // Main Internships Panel with background
        internshipsPanel = new JPanel() {
            Image backgroundImage = new ImageIcon("src\\picture.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                g.setColor(new Color(0, 0, 0, 195));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        internshipsPanel.setLayout(null);
        internshipsPanel.setBounds(0, 0, 1280, 720);
        internshipsPanel.setOpaque(false);

        // Header Labels
        JLabel internshipsLabel = new JLabel("ONLINE JOBS & INTERNSHIP PORTAL");
        internshipsLabel.setBounds(360, 50, 600, 30);
        internshipsLabel.setForeground(Color.WHITE);
        internshipsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        internshipsPanel.add(internshipsLabel);

        JLabel titleInternships = new JLabel("LAUNCH YOUR CAREER WITH INTERNSHIPS!");
        titleInternships.setBounds(420, 150, 600, 30);
        titleInternships.setForeground(new Color(191, 161, 129));
        titleInternships.setFont(new Font("Arial", Font.BOLD, 20));
        internshipsPanel.add(titleInternships);

        // Internships Container and Scroll
        internshipsContainer = new JPanel(null);
        internshipsContainer.setBackground(new Color(23, 133, 130));
        internshipsContainer.setOpaque(true);

        scrollPane = new JScrollPane(internshipsContainer);
        scrollPane.setBounds(150, 200, 950, 400);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBar(null);
        internshipsPanel.add(scrollPane);

        // Apply Panel
        applyPanel = new JPanel();
        applyPanel.setLayout(null);
        applyPanel.setBackground(new Color(23, 133, 130));
        applyPanel.setBounds(300, 200, 700, 350);
        applyPanel.setVisible(false);

        JLabel titleLabel = new JLabel("Apply Now for Internships");
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

        JLabel internshipLabel = new JLabel("Select Internship:");
        internshipLabel.setBounds(100, 150, 150, 30);
        internshipLabel.setForeground(Color.white);
        applyPanel.add(internshipLabel);

        // Load internships from the database
        List<Internship> internships = loadInternshipsFromDatabase();
        String[] internshipTitles = internships.stream().map(Internship::getTitle).toArray(String[]::new);
        Map<String, Integer> internshipTitleToIdMap = new HashMap<>();
        for (Internship internship : internships) {
            internshipTitleToIdMap.put(internship.getTitle(), internship.getId());
        }

        JComboBox<String> internshipComboBox = new JComboBox<>(internshipTitles);
        internshipComboBox.setBounds(250, 150, 300, 30);
        applyPanel.add(internshipComboBox);

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

        JButton closeButton = new JButton("Return to Internships");
        closeButton.setBounds(370, 310, 200, 30);
        closeButton.setBackground(new Color(191, 161, 129));
        applyPanel.add(closeButton);

        // Application submit
        submitButton.addActionListener(e -> {
            String userName = nameField.getText().trim();
            String userEmail = emailField.getText().trim();
            String selectedInternshipTitle = (String) internshipComboBox.getSelectedItem();
            String coverLetter = coverLetterArea.getText().trim();

            if (userName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your name.");
                return;
            }
            if (userEmail.isEmpty() || !userEmail.contains("@")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
                return;
            }
            if (selectedInternshipTitle == null || !internshipTitleToIdMap.containsKey(selectedInternshipTitle)) {
                JOptionPane.showMessageDialog(null, "Please select an internship.");
                return;
            }
            if (coverLetter.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a cover letter.");
                return;
            }

            int internshipId = internshipTitleToIdMap.get(selectedInternshipTitle);
            InternshipApplication application = new InternshipApplication(userName, userEmail, internshipId, coverLetter);
            InternshipApplicationDAO applicationDAO = new InternshipApplicationDAO();

            if (applicationDAO.submitInternshipApplication(application)) {
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
  		    internshipsContainer.setVisible(true);
  		    scrollPane.setVisible(true);

  		    // Bring jobsPanel back to front
  		    internshipPanel.this.setComponentZOrder(internshipsPanel, 0);
  		    internshipPanel.this.setComponentZOrder(applyPanel, 1);

  		    internshipPanel.this.revalidate();
  		    internshipPanel.this.repaint();
        });

        // Add main panels to this panel
        this.add(internshipsPanel);
        this.add(applyPanel);

        // Load internships AFTER all components are initialized
        loadInternships();
    }

    private void loadInternships() {
        internshipsContainer.removeAll();
        InternshipDAO internshipDAO = new InternshipDAO();
        List<Internship> internships = internshipDAO.getAllInternships();

        int y = 0;
        int spacing = 10;
        for (Internship internship : internships) {
            JPanel internshipPanel = createInternshipPanel(internship);
            internshipPanel.setBounds(10, y, 920, 130);
            internshipsContainer.add(internshipPanel);
            y += 130 + spacing;
        }

        // Set the container's size so the scroll pane can scroll properly
        internshipsContainer.setPreferredSize(new Dimension(950, y));
        internshipsContainer.revalidate();
        internshipsContainer.repaint();
    }

    private JPanel createInternshipPanel(Internship internship) {
        JPanel internshipPanel = new JPanel(null);
        internshipPanel.setBackground(new Color(23, 133, 130));
        internshipPanel.setOpaque(false);
        internshipPanel.setBorder(new LineBorder(new Color(191, 161, 129), 4, true));
        internshipPanel.setBorder(BorderFactory.createCompoundBorder(
            internshipPanel.getBorder(),
            new EmptyBorder(10, 10, 10, 10)
        ));

        JLabel title = new JLabel(internship.getTitle());
        title.setBounds(10, 10, 400, 20);
        title.setFont(new Font("Arial", Font.BOLD, 14));
        title.setForeground(Color.WHITE);
        internshipPanel.add(title);

        JLabel stipend = new JLabel("Stipend: " + internship.getStipend());
        stipend.setBounds(10, 35, 400, 20);
        stipend.setFont(new Font("Arial", Font.PLAIN, 12));
        stipend.setForeground(Color.WHITE);
        internshipPanel.add(stipend);

        JLabel location = new JLabel("Location: " + internship.getLocation());
        location.setBounds(10, 60, 400, 20);
        location.setFont(new Font("Arial", Font.PLAIN, 12));
        location.setForeground(Color.WHITE);
        internshipPanel.add(location);

        JButton applyButton = createRoundedButton("Apply", 750, 90);
        internshipPanel.add(applyButton);
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	   applyPanel.setVisible(true);
	                scrollPane.setVisible(false);
	                internshipsContainer.setVisible(false);
	                // Bring applyPanel to front
	               internshipPanel.this.setComponentZOrder(applyPanel, 0);
	               internshipPanel.this.setComponentZOrder(internshipsPanel, 1);
	               internshipPanel.this.revalidate();
	               internshipPanel.this.repaint();
            }
        });

        return internshipPanel;
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

    private List<Internship> loadInternshipsFromDatabase() {
        InternshipDAO internshipDAO = new InternshipDAO();
        return internshipDAO.getAllInternships();
    }
}

