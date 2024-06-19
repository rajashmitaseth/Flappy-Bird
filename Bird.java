
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Bird extends JPanel{
    Background background = new Background();
    Base base = new Base();

    String[] birdColorList = {"yellow", "red", "blue"};
    String birdColor = birdColorList[0];

    ImageIcon birdUpFlapImageIcon = new ImageIcon(birdColor + "bird-upflap.png");
    ImageIcon birdMidFlapImageIcon = new ImageIcon(birdColor + "bird-midflap.png");
    ImageIcon birdDownFlapImageIcon = new ImageIcon(birdColor + "bird-downflap.png");
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
        birdUpFlapImageIcon = new ImageIcon(birdColor + "bird-upflap.png");
        birdMidFlapImageIcon = new ImageIcon(birdColor + "bird-midflap.png");
        birdDownFlapImageIcon = new ImageIcon(birdColor + "bird-downflap.png");
        birdImageIcon = birdDownFlapImageIcon;
        wingPositions[0] = birdUpFlapImageIcon;
        wingPositions[1] = birdMidFlapImageIcon;
        wingPositions[2] = birdDownFlapImageIcon;
        wingPositions[3] = birdMidFlapImageIcon;
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

}
