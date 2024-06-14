
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Bird extends JPanel {
    ImageIcon birdImage = new ImageIcon("yellowbird-midflap.png");
    int x = 0;
    int y = 0;
    
    public Bird() {
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(birdImage.getImage(), x, y, this);
    }
}
