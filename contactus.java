import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class contactus extends JPanel {
    public contactus() {
        JPanel contactpanel = new JPanel() {
            Image backgroundImage = new ImageIcon("src\\picture.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                g.setColor(new Color(0, 0, 0, 200));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        contactpanel.setLayout(null);
        contactpanel.setPreferredSize(new Dimension(1280, 720));
        this.setLayout(null);
        contactpanel.setBounds(0, 0, 1280, 720);

        // Picture panel
        JPanel pic2 = new JPanel();
        pic2.setBounds(180, 150, 421, 350);
        pic2.setBackground(new Color(191, 161, 129, 0));
        contactpanel.add(pic2);
        ImageIcon icon2 = new ImageIcon("src\\picture3.png");
        JLabel label2 = new JLabel(icon2);
        label2.setBounds(0, 0, 421, 350);
        pic2.add(label2);

        // Contact form panel
        JPanel contactPanel = new JPanel(null);
        contactPanel.setBounds(650, 150, 500, 400);
        contactPanel.setBackground(new Color(191, 161, 129, 0));
        contactpanel.add(contactPanel);

        JLabel contactLabel = new JLabel("Get in touch with us");
        contactLabel.setBounds(0, 20, 300, 30);
        contactLabel.setFont(new Font("Arial", Font.BOLD, 26));
        contactLabel.setForeground(Color.white);
        contactPanel.add(contactLabel);

        // Email label and text field
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(0, 70, 130, 30);
        emailLabel.setForeground(Color.white);
        contactPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(0, 100, 400, 30);
        contactPanel.add(emailField);

        // Name label and text field
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(0, 140, 130, 30);
        nameLabel.setForeground(Color.white);
        contactPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(0, 170, 400, 30);
        contactPanel.add(nameField);

        // Message label and text area
        JLabel messageLabel = new JLabel("Message");
        messageLabel.setBounds(0, 210, 130, 30);
        messageLabel.setForeground(Color.white);
        contactPanel.add(messageLabel);

        JTextArea messageArea = new JTextArea();
        messageArea.setBounds(0, 240, 400, 60);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        contactPanel.add(messageArea);

        // Submit button as RoundedButton
        RoundedButton submitButton = createRoundedButton("Submit", 150, 360);
        contactPanel.add(submitButton);

        submitButton.addActionListener(e -> {
            String userName = nameField.getText().trim();
            String userEmail = emailField.getText().trim();
            String message = messageArea.getText().trim();

            // Validation checks
            if (userName.isEmpty() || userEmail.isEmpty() || message.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                return;
            }

            // Email format validation
            if (!userEmail.contains("@")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
                return;
            }

            // Create an instance of the handler and save the message
            ContactMessage contactMessage = new ContactMessage(userName, userEmail, message);
            ContactMessageDAO messageHandler = new ContactMessageDAO();
            boolean success = messageHandler.submitContactMessage(contactMessage);

            if (success) {
                JOptionPane.showMessageDialog(null, "Message submitted successfully!");
                // Clear fields after submission
                nameField.setText("");
                emailField.setText("");
                messageArea.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to submit message. Please try again.");
            }
        });

        this.add(contactpanel);
    }
    private RoundedButton createRoundedButton(String text, int x, int y) {
        RoundedButton btn = new RoundedButton(text, 15);
        btn.setBounds(x, y, 100, 40);
        btn.setBackground(new Color(191, 161, 129));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorderColor(btn.getBackground()); // Set initial border color

        // Modern hover effects
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btn.setBackground(new Color(100, 80, 60)); // Darker effect
                btn.setBorderColor(new Color(100, 80, 60)); // Match border color
                btn.setPreferredSize(new Dimension(105, 42)); // Slightly increase preferred size
                btn.revalidate(); // Update layout
                btn.repaint(); // Repaint to ensure rounded shape
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(191, 161, 129)); // Original color
                btn.setBorderColor(btn.getBackground()); // Match border color
                btn.setPreferredSize(new Dimension(100, 40)); // Reset preferred size
                btn.revalidate(); // Update layout
                btn.repaint(); // Repaint to ensure rounded shape
            }
        });
        return btn;
    }

}
