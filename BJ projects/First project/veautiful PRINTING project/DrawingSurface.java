import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.JPanel;

class DrawingSurface extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = getSize();
        Insets insets = getInsets();
        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;
        
        g2d.setColor(Color.white);
        g2d.fillRect(0,0,w,h);

        g2d.setColor(Color.blue);
        g2d.drawLine(2, 2, 2, h-3);
        g2d.drawLine(2, h-3, w-3, h-3);
        g2d.drawLine(w-3, h-3, w-3, 2);
        g2d.drawLine(w-3, 2, 2, 2);

        g2d.setColor(Color.red);
        g2d.drawRect(5, 5, 180, 20);
        g2d.fillRect (5, 5, 180, 20);
        g2d.setColor(Color.black);
        g2d.drawString("The window's width is " + size.width + ".", 10, 20);

        g2d.setColor(Color.black);
        g2d.drawRect(5, 35, 185, 20);
        g2d.drawString("The window's height is " + size.height + ".", 10, 50);

        g2d.setColor(Color.gray);
        g2d.drawRect(5, 65, 185, 20);
        g2d.drawString("The window's left inset is " + insets.left + ".", 10, 80);

        g2d.setColor(Color.green);
        g2d.drawRect(5, 95, 195, 20);
        g2d.drawString("The window's right inset is " + insets.right + ".", 10, 110);

        g2d.setColor(Color.orange);
        g2d.drawRect(5, 125, 185, 20);
        g2d.drawString("The window's top inset is " + insets.top + ".", 10, 140);

        g2d.setColor(Color.pink);
        g2d.drawRect(5, 155, 210, 20);
        g2d.drawString("The window's bottom inset is " + insets.bottom + ".", 10, 170);
    }
}