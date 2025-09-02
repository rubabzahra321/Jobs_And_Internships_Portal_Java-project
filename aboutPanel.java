import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class aboutPanel extends JPanel {
    public aboutPanel() {
        JPanel AboutPanel = new JPanel() {
            Image backgroundImage = new ImageIcon("src\\picture.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                g.setColor(new Color(0, 0, 0, 200));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        AboutPanel.setLayout(null);
        AboutPanel.setPreferredSize(new Dimension(1280, 720));
        this.setLayout(null);
        AboutPanel.setBounds(0, 0, 1280, 720);

        // Replace standard buttons with RoundedButton
        RoundedButton btn1 = createRoundedButton("About", 500, 580);
        AboutPanel.add(btn1);

        RoundedButton btn2 = createRoundedButton("Services", 610, 580);
        AboutPanel.add(btn2);

        RoundedButton btn3 = createRoundedButton("Explore", 720, 580);
        AboutPanel.add(btn3);

        //---------------------FIRST PANEL FOR PICTURE-----------------------------
        JPanel pic1 = new JPanel();
        pic1.setBounds(150, 180, 500, 450);
        pic1.setBackground(new Color(191, 161, 129, 0));
        AboutPanel.add(pic1);
        ImageIcon icon1 = new ImageIcon("src\\aboutus.png");
        JLabel label1 = new JLabel(icon1);
        label1.setBounds(0, 0, 500, 450);
        pic1.add(label1);
        pic1.setVisible(false);

        //-------------------------------first picture text-------------------------    
        JPanel text1 = new JPanel();
        text1.setLayout(null);
        text1.setBounds(600, 160, 550, 350);
        text1.setBackground(new Color(191, 161, 130, 0));
        AboutPanel.add(text1);
        JLabel aboutus = new JLabel("WHO WE ARE??");
        aboutus.setBounds(120, 40, 250, 30);
        aboutus.setForeground(new Color(191, 161, 129));
        aboutus.setFont(new Font("Ariel", Font.BOLD, 30));
        text1.add(aboutus);
        JTextArea area1 = new JTextArea();
        area1.setText(
                "At Online Jobs And Internship Portal, we prioritize our people, fostering an inclusive environment that values collaboration and innovation. We provide professional growth opportunities, a supportive culture, and a comprehensive benefits package, including. Our commitment to work-life balance ensures that you can excel both personally and professionally. Join us to thrive in your career and make a meaningful impact in industry while being part of a community dedicated to excellence!");
        area1.setLineWrap(true);
        area1.setWrapStyleWord(true);
        area1.setBackground(new Color(191, 161, 130, 0));
        area1.setBounds(10, 90, 500, 250);
        area1.setForeground(Color.WHITE);
        area1.setFont(new Font("Ariel", Font.PLAIN, 15));
        area1.setEditable(false);
        text1.add(area1);
        text1.setVisible(false);

        //--------------------------SECOND PANEL FOR PICTURE-------------------------
        JPanel pic2 = new JPanel();
        pic2.setBounds(180, 150, 421, 350);
        pic2.setBackground(new Color(191, 161, 129, 0));
        AboutPanel.add(pic2);
        ImageIcon icon2 = new ImageIcon("src\\aboutus2.png");
        JLabel label2 = new JLabel(icon2);
        label2.setBounds(0, 0, 421, 350);
        pic2.add(label2);
        pic2.setVisible(false);

        //-------------------------------SECOND picture text-------------------------    
        JPanel text2 = new JPanel();
        text2.setLayout(null);
        text2.setBounds(600, 160, 550, 350);
        text2.setBackground(new Color(191, 161, 130, 0));
        AboutPanel.add(text2);
        JLabel aboutus2 = new JLabel("WE HAVE VARIETY OF SERVICES!");
        aboutus2.setBounds(50, 40, 450, 30);
        aboutus2.setForeground(new Color(191, 161, 129));
        aboutus2.setFont(new Font("Ariel", Font.BOLD, 25));
        text2.add(aboutus2);
        JTextArea area2 = new JTextArea();
        area2.setText(
                "At Online Jobs And Internship Portal, we prioritize our people, cultivating an inclusive environment that encourages collaboration and innovation. We provide a diverse range of job and internship opportunities—remote, hybrid, and on-site—along with competitive compensation and a comprehensive benefits package, including. Join us to make a meaningful impact in the industry while becoming part of a community committed to excellence and continuous professional development. Explore rewarding career paths where your contributions are valued, and your success is celebrated!");
        area2.setLineWrap(true);
        area2.setWrapStyleWord(true);
        area2.setBackground(new Color(191, 161, 130, 0));
        area2.setBounds(20, 90, 550, 330);
        area2.setForeground(Color.WHITE);
        area2.setFont(new Font("Ariel", Font.PLAIN, 15));
        area2.setEditable(false);
        text2.add(area2);
        text2.setVisible(false);

        // --------------------------THIRD PANEL FOR PICTURE-------------------------
        JPanel pic3 = new JPanel();
        pic3.setBounds(180, 190, 421, 350);
        pic3.setBackground(new Color(191, 161, 129, 0));
        AboutPanel.add(pic3);
        ImageIcon icon3 = new ImageIcon("src\\aboutus3.png");
        JLabel label3 = new JLabel(icon3);
        label3.setBounds(0, 0, 421, 350);
        pic3.add(label3);

        // -------------------------------THIRD PICTURE TEXT-------------------------
        JPanel text3 = new JPanel();
        text3.setLayout(null);
        text3.setBounds(600, 160, 550, 350);
        text3.setBackground(new Color(191, 161, 130, 0));
        AboutPanel.add(text3);
        JLabel aboutus3 = new JLabel("EXPLORE US MORE!");
        aboutus3.setBounds(140, 40, 450, 30);
        aboutus3.setForeground(new Color(191, 161, 129));
        aboutus3.setFont(new Font("Ariel", Font.BOLD, 25));
        text3.add(aboutus3);
        JTextArea area3 = new JTextArea();
        area3.setText(
                "We connect job seekers with top employers. Our platform aims to simplify the job search process and offer opportunities for growth and career advancement."
                        + "\n" + "\nEmail: info@jobportal.com\r\n" + "Contact Number: +123 456 7890");
        area3.setLineWrap(true);
        area3.setWrapStyleWord(true);
        area3.setBackground(new Color(191, 161, 130, 0));
        area3.setBounds(20, 90, 550, 100);
        area3.setForeground(Color.WHITE);
        area3.setFont(new Font("Ariel", Font.PLAIN, 15));
        area3.setEditable(false);
        text3.add(area3);
        this.add(AboutPanel);

        //------------------------------ACTION LISTENERS FOR BUTTONS-----------------------------
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pic1.setVisible(true);
                text1.setVisible(true);
                pic2.setVisible(false);
                text2.setVisible(false);
                pic3.setVisible(false);
                text3.setVisible(false);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pic1.setVisible(false);
                text1.setVisible(false);
                pic2.setVisible(true);
                text2.setVisible(true);
                pic3.setVisible(false);
                text3.setVisible(false);
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pic3.setVisible(true);
                text3.setVisible(true);
                pic2.setVisible(false);
                text2.setVisible(false);
                pic1.setVisible(false);
                text1.setVisible(false);
            }
        });
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
                btn.setSize(105, 42); // Slightly increase size
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(191, 161, 129)); // Original color
                btn.setBorderColor(btn.getBackground()); // Match border color
                btn.setSize(100, 40); // Reset size
            }
        });
        return btn;
    }

}
