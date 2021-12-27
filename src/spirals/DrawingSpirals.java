package spirals;

import javax.swing.*;
import java.awt.*;

public class DrawingSpirals extends JPanel {

    public void drawSpiralLine(Graphics g){

//        super.paintComponent(g);
        int width = getSize().width;
        int length = getSize().height  ;

        int horizontalCenter = width / 2;
        int verticalCenter = length / 2;

        for ( int counter = 0; counter <= 5; counter ++){
            int i = counter * 10;
            g.drawLine(horizontalCenter + i, verticalCenter + i , horizontalCenter +i, verticalCenter + 10 +i);
            g.drawLine(horizontalCenter + i, verticalCenter+10+i, horizontalCenter-10-i, verticalCenter + 10 +i);
            g.drawLine(horizontalCenter-10-i, verticalCenter+10+i, horizontalCenter-10-i, verticalCenter-10-i);
            g.drawLine(horizontalCenter-10-i,  verticalCenter-10-i, horizontalCenter+ 10+i, verticalCenter-10-i);
            g.drawLine(horizontalCenter+10+i, verticalCenter-10-i,horizontalCenter+10+i, horizontalCenter+10+i);
        }
    }

    public static void main(String[] args) {
        DrawingSpirals panel = new DrawingSpirals();

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(300, 300);
        application.setVisible(true);
    }
}
