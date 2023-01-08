import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {

  public static void main(String[] args) {
    // Create the window
    JFrame frame = new JFrame();
    frame.setSize(new Dimension(500, 500));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the panel that will hold the shapes
    JPanel panel = new JPanel() {
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the color to red
        g.setColor(Color.RED);

        // Draw the rectangle
        g.drawRect(10, 10, 200, 200);

        // Draw the heart
        Polygon heart = new Polygon();
        heart.addPoint(250, 400);
        heart.addPoint(300, 300);
        heart.addPoint(350, 400);
        heart.addPoint(275, 450);
        heart.addPoint(225, 450);
        g.fillPolygon(heart);
      }
    };
    frame.add(panel);

    // Display the window
    frame.setVisible(true);
  }
}
