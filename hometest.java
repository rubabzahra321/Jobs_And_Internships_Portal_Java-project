import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class hometest extends JFrame {
	public hometest() {
		setTitle("Job Portal");
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// --------------------------- Main Tabbed Pane-----------------------------
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(new Color(23, 133, 130));
		tabbedPane.setBounds(0, 0, 100, 70);
		tabbedPane.setFont(new Font("Ariel", Font.BOLD, 15));

// --------------------------Home Panel with Background Image------------------------
		JPanel homePanel = new JPanel() {
			Image backgroundImage = new ImageIcon("src\\picture.jpg").getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
				g.setColor(new Color(0, 0, 0, 180));
				g.fillRect(0, 0, getWidth(), getHeight());
			}
		};

		homePanel.setLayout(null);
		JLabel homeLabel = new JLabel("ONLINE JOBS & INTERNSHIP PORTAL");
		homeLabel.setBounds(360, 50, 600, 30);
		homeLabel.setForeground(Color.WHITE);
		homeLabel.setFont(new Font("Ariel", Font.BOLD, 30));
		homePanel.add(homeLabel);

		JLabel titleforjobs = new JLabel("FIND YOUR DREAM JOB TODAY!");
		titleforjobs.setBounds(480, 150, 600, 30);
		titleforjobs.setForeground(new Color(191, 161, 129));
		titleforjobs.setFont(new Font("Ariel", Font.BOLD, 20));
		homePanel.add(titleforjobs);

		JLabel titleforinternship = new JLabel("LAUNCH YOUR CAREER WITH INTERNSHIPS!");
		titleforinternship.setBounds(400, 400, 600, 30);
		titleforinternship.setForeground(new Color(191, 161, 129));
		titleforinternship.setFont(new Font("Ariel", Font.BOLD, 20));
		homePanel.add(titleforinternship);

//-----------------------------JOBS PANEL OF HOMEPAGE-----------------------

		JPanel job1 = new JPanel();
		job1.setLayout(null);
		job1.setBounds(150, 220, 300, 150);
		job1.setBackground(new Color(23, 133, 130));
		JLabel l1 = new JLabel("Top Company Hiring");
		l1.setBounds(60, 10, 200, 30);
		l1.setForeground(Color.white);
		l1.setFont(new Font("Ariel", Font.BOLD, 18));
		JLabel l7 = new JLabel("Get hired by leading global");
		JLabel l8 = new JLabel("companies across industries.");
		l7.setBounds(70, 35, 200, 25);
		l8.setBounds(60, 55, 200, 25);
		l7.setForeground(Color.white);
		l8.setForeground(Color.white);
		l7.setFont(new Font("Ariel", Font.PLAIN, 15));
		l8.setFont(new Font("Ariel", Font.PLAIN, 15));
		job1.add(l1);
		job1.add(l7);
		job1.add(l8);

		JButton b1 = new JButton("On Site Jobs");
		b1.setBounds(60, 90, 200, 30);
		b1.setBackground(new Color(191, 161, 129));
		b1.setFont(new Font("Aerial", Font.BOLD, 15));
		job1.add(b1);

		homePanel.add(job1);

		JPanel job2 = new JPanel();
		job2.setLayout(null);
		job2.setBounds(500, 220, 300, 150);
		job2.setBackground(new Color(23, 133, 130));
		JLabel l2 = new JLabel("Remote Opportunities");
		l2.setBounds(60, 10, 200, 30);
		l2.setForeground(Color.white);
		l2.setFont(new Font("Ariel", Font.BOLD, 18));
		job2.add(l2);
		JLabel lup = new JLabel("Work from anywhere");
		JLabel ldown = new JLabel("discover remote companies.");
		lup.setBounds(70, 35, 200, 25);
		ldown.setBounds(60, 55, 200, 25);
		lup.setForeground(Color.white);
		ldown.setForeground(Color.white);
		lup.setFont(new Font("Ariel", Font.PLAIN, 15));
		ldown.setFont(new Font("Ariel", Font.PLAIN, 15));

		job2.add(lup);
		job2.add(ldown);

		JButton b2 = new JButton("Remote Jobs");
		b2.setBounds(60, 90, 200, 30);
		b2.setBackground(new Color(191, 161, 129));
		b2.setFont(new Font("Aerial", Font.BOLD, 15));
		job2.add(b2);
		homePanel.add(job2);

		JPanel job3 = new JPanel();
		job3.setLayout(null);
		job3.setBounds(850, 220, 300, 150);
		job3.setBackground(new Color(23, 133, 130));

		JLabel l3 = new JLabel("Hybird Jobs");
		l3.setBounds(100, 10, 200, 30);
		l3.setForeground(Color.white);
		l3.setFont(new Font("Arial", Font.BOLD, 18));

		JLabel first = new JLabel("Find jobs as per need");
		first.setBounds(90, 35, 200, 25);
		first.setForeground(Color.white);
		first.setFont(new Font("Arial", Font.PLAIN, 15));

		JLabel second = new JLabel("and work from anywhere.");
		second.setBounds(80, 55, 200, 25);
		second.setForeground(Color.white);
		second.setFont(new Font("Arial", Font.PLAIN, 15));

		JButton b3 = new JButton("Hybird Jobs");
		b3.setBounds(60, 90, 200, 30);
		b3.setBackground(new Color(191, 161, 129));
		b3.setFont(new Font("Arial", Font.BOLD, 15));
		job3.add(l3);
		job3.add(first);
		job3.add(second);
		job3.add(b3);
		homePanel.add(job3);

//------------------------INTERNSHIP PANEL OF HOMEPAGE----------------------------

		JPanel intern1 = new JPanel();
		intern1.setLayout(null);
		intern1.setBounds(150, 460, 300, 150);
		intern1.setBackground(new Color(23, 133, 130));
		JLabel l4 = new JLabel("Summer Intrnships");
		l4.setBounds(70, 10, 200, 30);
		l4.setForeground(Color.white);
		l4.setFont(new Font("Ariel", Font.BOLD, 18));
		intern1.add(l4);

		JLabel f = new JLabel("Kickstart your career with");
		f.setBounds(70, 35, 200, 25);
		f.setForeground(Color.white);
		f.setFont(new Font("Arial", Font.PLAIN, 15));

		JLabel s = new JLabel("exciting summer internships.");
		s.setBounds(60, 55, 200, 25);
		s.setForeground(Color.white);
		s.setFont(new Font("Arial", Font.PLAIN, 15));

		JButton b4 = new JButton("Summer Internship");
		b4.setBounds(30, 90, 200, 30);
		b4.setBackground(new Color(191, 161, 129));
		b4.setFont(new Font("Arial", Font.BOLD, 15));

		intern1.add(f);
		intern1.add(s);
		intern1.add(b4);
		homePanel.add(intern1);

		JPanel intern2 = new JPanel();
		intern2.setLayout(null);
		intern2.setBounds(500, 460, 300, 150);
		intern2.setBackground(new Color(23, 133, 130));
		JLabel l5 = new JLabel("Paid Intrenships");
		l5.setBounds(80, 10, 200, 30);
		l5.setForeground(Color.white);
		l5.setFont(new Font("Ariel", Font.BOLD, 18));
		intern2.add(l5);
		JLabel fir = new JLabel("Earn while you learn");
		fir.setBounds(80, 35, 200, 25);
		fir.setForeground(Color.white);
		fir.setFont(new Font("Arial", Font.PLAIN, 15));

		JLabel sec = new JLabel("explore paid internships.");
		sec.setBounds(70, 55, 200, 25);
		sec.setForeground(Color.white);
		sec.setFont(new Font("Arial", Font.PLAIN, 15));

		JButton b5 = new JButton("Paid Internships");
		b5.setBounds(30, 90, 250, 30);
		b5.setBackground(new Color(191, 161, 129));
		b5.setFont(new Font("Arial", Font.BOLD, 15));

		intern2.add(fir);
		intern2.add(sec);
		intern2.add(b5);
		homePanel.add(intern2);

		JPanel intern3 = new JPanel();
		intern3.setLayout(null);
		intern3.setBounds(850, 460, 300, 150);
		intern3.setBackground(new Color(23, 133, 130));
		JLabel l6 = new JLabel("Virtual Internships");
		l6.setBounds(80, 10, 200, 30);
		l6.setForeground(Color.white);
		l6.setFont(new Font("Ariel", Font.BOLD, 18));
		intern3.add(l6);

		JLabel one = new JLabel("Gain Experience Remotely");
		one.setBounds(70, 35, 200, 25);
		one.setForeground(Color.white);
		one.setFont(new Font("Arial", Font.PLAIN, 15));

		JLabel two = new JLabel("with flexible internships.");
		two.setBounds(80, 55, 200, 25);
		two.setForeground(Color.white);
		two.setFont(new Font("Arial", Font.PLAIN, 15));

		JButton b6 = new JButton("Virtual Internships");
		b6.setBounds(30, 90, 230, 30);
		b6.setBackground(new Color(191, 161, 129));
		b6.setFont(new Font("Arial", Font.BOLD, 15));

		intern3.add(one);
		intern3.add(two);
		intern3.add(b6);
		homePanel.add(intern3);

		tabbedPane.addTab("Home", homePanel);

// ------------------------------MAIN JOBS PANEL---------------------------------------

		jobPanel Panel = new jobPanel();
		tabbedPane.addTab("Jobs", Panel);

// -----------------------------InternshipsPanel----------------------------------------------
		internshipPanel intern = new internshipPanel();
		tabbedPane.addTab("Internships", intern);

// --------------------------------About Panel--------------------------------------------
		aboutPanel aboutobj = new aboutPanel();

		tabbedPane.addTab("About", aboutobj);

// -------------------------------Contact Panel-----------------------------------------------
		contactus contactobj = new contactus();
		tabbedPane.addTab("Contact", contactobj);

// ------------------------------Add tabbed pane to the frame-----------------------------------------
		add(tabbedPane);
		setVisible(true);
		
	      // -------------------------------Admin Panel-----------------------------------------------
//        adminpannel adminobj = new adminpannel();
//        tabbedPane.addTab("Admin", adminobj);

//---------------------Action listner---------------------------------------
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Switch to the "Jobs" tab
				tabbedPane.setSelectedIndex(1);
			}
		});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Switch to the "Jobs" tab
				tabbedPane.setSelectedIndex(1);
			}
		});
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Switch to the "Jobs" tab
				tabbedPane.setSelectedIndex(1);
			}
		});
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Switch to the "Jobs" tab
				tabbedPane.setSelectedIndex(2);
			}
		});
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Switch to the "Jobs" tab
				tabbedPane.setSelectedIndex(2);
			}
		});
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Switch to the "Jobs" tab
				tabbedPane.setSelectedIndex(2);
			}
		});

//		mouse listners
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				b1.setBackground(new Color(143, 120, 95));
				b1.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
				b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				b1.setBounds(60, 90, 200, 30);
				b1.setBackground(new Color(191, 161, 129));
			}
		});
		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				b2.setBackground(new Color(143, 120, 95));
				b2.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
				b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				b2.setBounds(60, 90, 200, 30);
				b2.setBackground(new Color(191, 161, 129));
			}
		});
		b3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				b3.setBackground(new Color(143, 120, 95));
				b3.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
				b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				b3.setBounds(60, 90, 200, 30);
				b3.setBackground(new Color(191, 161, 129));
			}
		});
		b4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				b4.setBackground(new Color(143, 120, 95));
				b4.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
				b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				b4.setBounds(60, 90, 200, 30);
				b4.setBackground(new Color(191, 161, 129));
			}
		});
		b5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				b5.setBackground(new Color(143, 120, 95));
				b5.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
				b5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				b5.setBounds(60, 90, 200, 30);
				b5.setBackground(new Color(191, 161, 129));
			}
		});
		b6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				b6.setBackground(new Color(143, 120, 95));
				b6.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
				b6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				b6.setBounds(30, 90, 230, 30);
				b6.setBackground(new Color(191, 161, 129));
			}
		});

		intern1.addMouseListener(new MouseAdapter() {
			Rectangle originalBounds = intern1.getBounds(); // store original bounds

			@Override
			public void mouseEntered(MouseEvent e) {
				// New bounds: slightly larger and shifted upwards-left
				intern1.setBounds(originalBounds.x - 5, originalBounds.y - 2, originalBounds.width + 10,
						originalBounds.height + 5);
				intern1.setBackground(new Color(18, 110, 110)); // hover color
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Restore original bounds
				intern1.setBounds(originalBounds);
				intern1.setBackground(new Color(23, 133, 130)); // base color
			}
		});

		intern2.addMouseListener(new MouseAdapter() {
			Rectangle originalBounds = intern2.getBounds(); // store original bounds

			@Override
			public void mouseEntered(MouseEvent e) {
				// New bounds: slightly larger and shifted upwards-left
				intern2.setBounds(originalBounds.x - 5, originalBounds.y - 2, originalBounds.width + 10,
						originalBounds.height + 5);
				intern2.setBackground(new Color(18, 110, 110)); // hover color
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Restore original bounds
				intern2.setBounds(originalBounds);
				intern2.setBackground(new Color(23, 133, 130)); // base color
			}
		});

		intern3.addMouseListener(new MouseAdapter() {
			Rectangle originalBounds = intern3.getBounds(); // store original bounds

			@Override
			public void mouseEntered(MouseEvent e) {
				// New bounds: slightly larger and shifted upwards-left
				intern3.setBounds(originalBounds.x - 5, originalBounds.y - 2, originalBounds.width + 10,
						originalBounds.height + 5);
				intern3.setBackground(new Color(18, 110, 110)); // hover color
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Restore original bounds
				intern3.setBounds(originalBounds);
				intern3.setBackground(new Color(23, 133, 130)); // base color
			}
		});

		job1.addMouseListener(new MouseAdapter() {
			Rectangle originalBounds = job1.getBounds(); // store original bounds

			@Override
			public void mouseEntered(MouseEvent e) {
				// New bounds: slightly larger and shifted upwards-left
				job1.setBounds(originalBounds.x - 5, originalBounds.y - 2, originalBounds.width + 10,
						originalBounds.height + 5);
				job1.setBackground(new Color(18, 110, 110)); // hover color
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Restore original bounds
				job1.setBounds(originalBounds);
				job1.setBackground(new Color(23, 133, 130)); // base color
			}
		});

		job2.addMouseListener(new MouseAdapter() {
			Rectangle originalBounds = job2.getBounds(); // store original bounds

			@Override
			public void mouseEntered(MouseEvent e) {
				// New bounds: slightly larger and shifted upwards-left
				job2.setBounds(originalBounds.x - 5, originalBounds.y - 2, originalBounds.width + 10,
						originalBounds.height + 5);
				job2.setBackground(new Color(18, 110, 110)); // hover color
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Restore original bounds
				job2.setBounds(originalBounds);
				job2.setBackground(new Color(23, 133, 130)); // base color
			}
		});

		job3.addMouseListener(new MouseAdapter() {
			Rectangle originalBounds = job3.getBounds(); // store original bounds

			@Override
			public void mouseEntered(MouseEvent e) {
				// New bounds: slightly larger and shifted upwards-left
				job3.setBounds(originalBounds.x - 5, originalBounds.y - 2, originalBounds.width + 10,
						originalBounds.height + 5);
				job3.setBackground(new Color(18, 110, 110)); // hover color
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// Restore original bounds
				job3.setBounds(originalBounds);
				job3.setBackground(new Color(23, 133, 130)); // base color
			}
		});

	}

}
