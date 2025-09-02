import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WelcomeScreen extends JFrame {
    private int currentImageIndex = 0; // Index for the current background image
    private final Image[] backgroundImages = new Image[3];

    public WelcomeScreen() {
        // Load images
        loadImages();

        // Set up the frame
        setTitle("Welcome");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create a custom JPanel for the background
        JPanel homePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImages[currentImageIndex] != null) {
                    g.drawImage(backgroundImages[currentImageIndex], 0, 0, getWidth(), getHeight(), this);
                }
                g.setColor(new Color(0, 0, 0, 170)); // Semi-transparent black overlay
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        homePanel.setLayout(null); // Use null layout for absolute positioning

        // Add welcome message
        JLabel welcomeMessage = new JLabel("Welcome to the Portal");
        welcomeMessage.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeMessage.setForeground(Color.white);
        welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeMessage.setBounds(0, 150, 800, 40); // Centered horizontally
        homePanel.add(welcomeMessage);

        // Create and add the main title
        JLabel title = new JLabel("JOBS AND INTERNSHIPS PORTAL");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.white);
        title.setBounds(50, 200, 700, 60);
        homePanel.add(title);

        // Create and add the login button
        JButton loginButton = createButton("Login", 300, 500);
        // Action listener to redirect to login panel
        loginButton.addActionListener(e -> {
            LOGIN login = new LOGIN();
            login.setVisible(true); // Show the login panel
            dispose(); // Close the welcome screen
        });
        homePanel.add(loginButton);

        // Add an exit button
        JButton exitButton = createButton("Exit", 450, 500);
        // Action listener to exit the application
        exitButton.addActionListener(e -> System.exit(0));
        homePanel.add(exitButton);

        // Add the panel to the frame
        add(homePanel);

        // Timer to change the background image every 5 seconds
        Timer timer = new Timer(2000, e -> {
            currentImageIndex = (currentImageIndex + 1) % backgroundImages.length; // Cycle through images
            homePanel.repaint(); // Repaint the panel to update the background
        });
        timer.start(); // Start the timer
    }

    private void loadImages() {
        String[] imagePaths = {
            "src/picture.jpg", // Relative path to the image
            "src/picture2.jpg",
            "src/picture3.png"
        };

        for (int i = 0; i < imagePaths.length; i++) {
            ImageIcon imageIcon = new ImageIcon(imagePaths[i]);
            if (imageIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                backgroundImages[i] = imageIcon.getImage();
            } else {
                System.err.println("Error loading image: " + imagePaths[i]);
            }
        }
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 120, 40);
        button.setBackground(new Color(0, 150, 136)); // Attractive teal color
        button.setForeground(Color.white);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        button.setOpaque(true);
        
        // Mouse Listener for hover and pressed effects
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(0, 180, 158)); // Lighter teal on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(0, 150, 136)); // Original teal color
            }

            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(new Color(0, 120, 100)); // Darker teal when pressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(new Color(0, 180, 158)); // Revert to hover color when released
            }
        });

        return button;
    }

}
