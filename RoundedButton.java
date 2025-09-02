import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {
    private int radius;
    private Color borderColor;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        this.borderColor = getBackground(); // Set initial border color to match background
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(borderColor); // Use the border color that matches the button background
        g2.draw(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));
    }

    public void setBorderColor(Color color) {
        this.borderColor = color; // Method to set the border color
        repaint(); // Repaint to update the border color
    }
}
