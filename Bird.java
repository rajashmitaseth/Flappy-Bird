
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Bird extends JPanel{
    Background background = new Background();
    Base base = new Base();
    ImageIcon birdUpFlapImageIcon = new ImageIcon("yellowbird-upflap.png");
    ImageIcon birdMidFlapImageIcon = new ImageIcon("yellowbird-midflap.png");
    ImageIcon birdDownFlapImageIcon = new ImageIcon("yellowbird-downflap.png");
    ImageIcon birdImageIcon = birdDownFlapImageIcon;
    ImageIcon[] wingPositions = {birdUpFlapImageIcon, birdMidFlapImageIcon, birdDownFlapImageIcon, birdMidFlapImageIcon};
    int wingPosition = 0;
    int x = 0;
    int y = 0;
    int velocityY = 0;
    float gravity = 1f;
    
    public Bird() {
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        flap();
        graphics.drawImage(birdImageIcon.getImage(), x, y, this);
    }

    public void move() {
        velocityY += gravity;
        y += velocityY;
        y = Math.min(y, background.backgroundImageIcon.getIconHeight() - base.baseImageIcon.getIconHeight() - birdImageIcon.getIconHeight());
        y = Math.max(y, 0);
    }

    public void flap() {
        birdImageIcon = wingPositions[wingPosition];
        wingPosition++;
        if (wingPosition > 3) {
            wingPosition = 0;
        }
    }

    public void fixX() {
        x -= 2;
    }

    // public void fixY() {
    //     y -= 3;
    // }
}
