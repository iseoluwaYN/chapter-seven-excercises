package rainbow;

import javax.swing.*;
import java.awt.*;

public class DrawRainbow extends JPanel {

    private final static Color VIOLET = new Color(128, 0, 128);
    private final static Color INDIGO = new Color(75, 0, 130);

    private Color[] colors = { Color.WHITE, Color.WHITE, VIOLET, INDIGO, Color.BLUE,
            Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED };

   public DrawRainbow() {
        setBackground(Color.BLACK);
   }
   // draws a rainbow using concentric arcs
   public void paintComponent(Graphics g) {
           super.paintComponent(g);
           int radius = 20; // radius of an arc


           int centerX = getWidth() / 2;
           int centerY = getHeight() - 10;
           // draws filled arcs starting with the outermost
           for (int counter = colors.length; counter > 0; counter--) {
           // set the color for the current arc
           g.setColor(colors[counter - 1]);
           // fill the arc from 0 to 180 degrees
           g.fillArc(centerX - counter * radius,  centerY - counter * radius,
                   counter * radius * 2, counter * radius * 2, 0, 180);
           }
   }

        public static void main(String[] args){
              DrawRainbow panel = new DrawRainbow();
              JFrame application = new JFrame();
              application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              application.add(panel);
              application.setSize(400, 250);
              application.setVisible(true);
        }
}
