
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenDimension.getWidth();
        int screenHeight = (int)screenDimension.getHeight();
        int windowWidth = 288;
        int windowHeight = 624;
        Dimension windowDimension = new Dimension(windowWidth, windowHeight);
        int windowX = screenWidth/2 - windowWidth/2;
        int windowY = screenHeight/2 - windowHeight/2;
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(windowWidth, windowHeight);
        window.setMinimumSize(windowDimension);
        window.setVisible(true);
        window.setLocation(windowX, windowY);

        Background bg = new Background();
        bg.setBounds(0, 0, bg.backgroundImageIcon.getIconWidth(), bg.backgroundImageIcon.getIconHeight());
        window.add(bg);
        
        Bird bird = new Bird();
        bird.setBounds(0, 0, bird.birdImage.getIconWidth(), bird.birdImage.getIconHeight());
        window.add(bird);

        Base base = new Base();
        base.y = bg.backgroundImageIcon.getIconHeight();
        base.setBounds(0, bg.backgroundImageIcon.getIconHeight(), base.baseImage.getIconWidth(), base.baseImage.getIconHeight());
        window.add(base);
        window.pack();
    }
}