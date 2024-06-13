import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame {
    ImageIcon backgroundImage;
    Dimension screenDimension;
    int screenWidth;
    int screenHeight;
    int windowWidth;
    int windowHeight;
    int windowX;
    int windowY;

    public Window() {
        backgroundImage = new ImageIcon("background-day.png");

        screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = (int)screenDimension.getWidth();
        screenHeight = (int)screenDimension.getHeight();
        windowWidth = 360;
        windowHeight = 640;
        // windowDimension.setSize(windowWidth, windowHeight);
        windowX = screenWidth/2 - windowWidth/2;
        windowY = screenHeight/2 - windowHeight/2;

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(windowX, windowY);
        setSize(windowWidth, windowHeight);
        setResizable(false);
        // setMinimumSize();
        setTitle("Flappy Bird");
        
        add(new JLabel(backgroundImage));
        pack();
    }
}
