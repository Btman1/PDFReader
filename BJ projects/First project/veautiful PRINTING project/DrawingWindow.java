import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DrawingWindow extends JFrame {

    public DrawingWindow() {
        setTitle("Drawing Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new DrawingSurface());

        setSize(400, 300);
        setLocationRelativeTo(null); // centers window in display screen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    DrawingWindow dw = new DrawingWindow();
                    dw.setVisible(true);
                }
            });
    }
}