import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class LOGIN extends JFrame {
	private JTextField emailField;
	private JPasswordField passwordField;
	private ImageIcon icon;
	private JLabel pictureLabel;

	public LOGIN() {
		DatabaseConnectionChecker database = new DatabaseConnectionChecker();
		setTitle("JobPortal - Login");
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);

		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBounds(0, 0, 380, 900);
		loginPanel.setBackground(new Color(23, 133, 130, 200));

		JLabel title = new JLabel("JOBS AND INTERNSHIPS");
		title.setBounds(10, 100, 400, 60);
		title.setFont(new Font("Arial", Font.BOLD, 30));
		title.setForeground(Color.white);
		loginPanel.add(title);

		JLabel title2 = new JLabel("PORTAL");
		title2.setBounds(135, 140, 400, 60);
		title2.setFont(new Font("Arial", Font.BOLD, 30));
		title2.setForeground(Color.white);
		loginPanel.add(title2);
		add(loginPanel);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(50, 250, 300, 400);
		mainPanel.setBackground(new Color(191, 161, 129));
		loginPanel.add(mainPanel);

		JLabel title6 = new JLabel("WELCOME TO OUR PORTAL");
		title6.setBounds(10, 50, 300, 30);
		title6.setFont(new Font("Arial", Font.BOLD, 20));
		title6.setForeground(Color.black);
		mainPanel.add(title6);

		JLabel userLabel = new JLabel("Login as User");
		userLabel.setBounds(80, 140, 200, 30);
		userLabel.setFont(new Font("Arial", Font.BOLD, 20));
		userLabel.setForeground(Color.black);
		mainPanel.add(userLabel);

		JButton userLoginButton = new JButton("User Login");
		userLoginButton.setBounds(80, 180, 150, 30);
		userLoginButton.setBackground(new Color(23, 133, 130));
		userLoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mainPanel.add(userLoginButton);
		
		JButton adminLoginButton = new JButton("Admin Login");
		adminLoginButton.setBounds(80, 230, 150, 30);
		adminLoginButton.setBackground(new Color(23, 133, 130));
		adminLoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mainPanel.add(adminLoginButton);

		JButton closeMainPanel = new JButton("Close");
		closeMainPanel.setBounds(100, 290, 100, 30);
		closeMainPanel.setBackground(new Color(23, 133, 130));
		closeMainPanel.addActionListener(e -> System.exit(0));
		mainPanel.add(closeMainPanel);

		JPanel loginbox = new JPanel();
		loginbox.setLayout(null);
		loginbox.setBounds(50, 250, 300, 400);
		loginbox.setBackground(new Color(191, 161, 129));

		JLabel title3 = new JLabel("USER LOGIN");
		title3.setBounds(80, 50, 200, 30);
		title3.setFont(new Font("Arial", Font.BOLD, 25));
		title3.setForeground(Color.black);
		loginbox.add(title3);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(50, 150, 100, 30);
		loginbox.add(emailLabel);

		emailField = new JTextField(20);
		emailField.setBounds(150, 150, 140, 30);
		loginbox.add(emailField);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(50, 200, 100, 30);
		loginbox.add(passwordLabel);

		passwordField = new JPasswordField(20);
		passwordField.setBounds(150, 200, 140, 30);
		loginbox.add(passwordField);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(50, 270, 100, 30);
		loginButton.setBackground(new Color(23, 133, 130));
		loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginbox.add(loginButton);

		JLabel toggleLabel = new JLabel("Don't have an account?");
		toggleLabel.setBounds(30, 320, 250, 30);
		loginbox.add(toggleLabel);

		JButton togglebutton = new JButton("Sign up");
		togglebutton.setBounds(190, 320, 100, 30);
		togglebutton.setBackground(new Color(23, 133, 130));
		togglebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginbox.add(togglebutton);

		JButton closeButton = new JButton("Close");
		closeButton.setBounds(160, 270, 100, 30);
		closeButton.setBackground(new Color(23, 133, 130));
		closeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginbox.add(closeButton);
		loginbox.setVisible(false);
		loginPanel.add(loginbox);

		JPanel signup = new JPanel();
		signup.setLayout(null);
		signup.setBounds(50, 250, 300, 400);
		signup.setBackground(new Color(191, 161, 129));
		JLabel title4 = new JLabel("SIGN UP FOR EXCITING");
		title4.setBounds(30, 20, 300, 30);
		title4.setFont(new Font("Arial", Font.BOLD, 20));
		title4.setForeground(Color.black);
		JLabel title5 = new JLabel(" OPPORTUNITIES");
		title5.setBounds(60, 50, 300, 30);
		title5.setFont(new Font("Arial", Font.BOLD, 20));
		title5.setForeground(Color.black);
		signup.add(title5);
		signup.add(title4);

		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(50, 100, 100, 30);
		signup.add(nameLabel);

		JTextField nameField = new JTextField(20);
		nameField.setBounds(150, 100, 140, 30);
		signup.add(nameField);

		JLabel signupEmailLabel = new JLabel("Email:");
		signupEmailLabel.setBounds(50, 150, 100, 30);
		signup.add(signupEmailLabel);

		JTextField signupEmailField = new JTextField(20);
		signupEmailField.setBounds(150, 150, 140, 30);
		signup.add(signupEmailField);

		JLabel signupPasswordLabel = new JLabel("Password:");
		signupPasswordLabel.setBounds(50, 200, 100, 30);
		signup.add(signupPasswordLabel);

		JPasswordField signupPasswordField = new JPasswordField(20);
		signupPasswordField.setBounds(150, 200, 140, 30);
		signup.add(signupPasswordField);

		JButton signupButton = new JButton("Sign Up");
		signupButton.setBounds(90, 270, 100, 30);
		signupButton.setBackground(new Color(23, 133, 130));
		signupButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signup.add(signupButton);
		JButton close = new JButton("Return");
		close.setBounds(90, 320, 100, 30);
		close.setBackground(new Color(23, 133, 130));
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signup.add(close);
		signup.setVisible(false);
		loginPanel.add(signup);

		JPanel picturePanel = new JPanel();
		picturePanel.setLayout(null);
		picturePanel.setBounds(380, 0, 900, 900);
		icon = new ImageIcon("src\\picture.jpg");

		pictureLabel = new JLabel(icon);
		pictureLabel.setBounds(0, 0, 900, 750);
		picturePanel.add(pictureLabel);
		JPanel overlayPanel = new JPanel();
		overlayPanel.setLayout(null);
		overlayPanel.setBounds(0, 0, 900, 750);
		overlayPanel.setBackground(new Color(0, 0, 0, 150)); // Semi-transparent black
		overlayPanel.setVisible(true);
		picturePanel.add(overlayPanel); // Add overlay panel to picture panel
		add(picturePanel);
		setVisible(true);

		togglebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginbox.setVisible(false);
				signup.setVisible(true);
			}
		});

		loginButton.addActionListener(e -> {
			String email = emailField.getText().trim();
			String password = new String(passwordField.getPassword()).trim();

			if (email.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(LOGIN.this, "Please fill in all fields.", "Validation Error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (!email.matches("^\\S+@\\S+\\.\\S+$")) {
				JOptionPane.showMessageDialog(LOGIN.this, "Please enter a valid email address.", "Validation Error",
						JOptionPane.WARNING_MESSAGE);
				return;
				// Attempt to login

			}

			// Attempt to login
			Boolean user = curdoperationsclass.login(email, password);
			if (user != null) {
				JOptionPane.showMessageDialog(LOGIN.this, "Login Successful!");
				new hometest().setVisible(true);
				dispose();
			} else {
				JOptionPane.showMessageDialog(LOGIN.this, "Invalid credentials. Please try again.");
			}

		});

		signupButton.addActionListener(e -> {
			String name = nameField.getText().trim();
			String email = signupEmailField.getText().trim();
			String password = new String(signupPasswordField.getPassword()).trim();

			if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(LOGIN.this, "Please fill in all fields.", "Validation Error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (!email.matches("^\\S+@\\S+\\.\\S+$")) {
				JOptionPane.showMessageDialog(LOGIN.this, "Please enter a valid email address.", "Validation Error",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (password.length() < 6) {
				JOptionPane.showMessageDialog(LOGIN.this, "Password should be at least 6 characters long.",
						"Validation Error", JOptionPane.WARNING_MESSAGE);
				return;
			}

			// Check if email already exists
			if (curdoperationsclass.emailExists(email)) {
				JOptionPane.showMessageDialog(LOGIN.this, "Email already registered. Please use a different email.",
						"Validation Error", JOptionPane.WARNING_MESSAGE);
				return;
			}

			// Attempt to sign up
			boolean signUpSuccess = curdoperationsclass.signUp(name, email, password);
			if (signUpSuccess) {
				JOptionPane.showMessageDialog(LOGIN.this, "Sign Up Successful!");
				loginbox.setVisible(true);
				signup.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(LOGIN.this, "Sign Up Failed. Please try again.");
			}
		});

		userLoginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginbox.setVisible(true);
				mainPanel.setVisible(false);
				signup.setVisible(false);
			}
		});

		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(true);
				loginbox.setVisible(false);
				signup.setVisible(false);
			}
		});

		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				loginbox.setVisible(true);
				signup.setVisible(false);
			}
		});
		adminLoginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminpannel adminPanel = new adminpannel();
			    JFrame adminFrame = new JFrame("Admin Panel");
			    adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    adminFrame.setContentPane(adminPanel);
			    adminFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximize the frame
			    adminFrame.setVisible(true);
			    
			}
		});

	}
	

}
