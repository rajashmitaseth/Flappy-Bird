
import java.awt.Graphics;
import java.util.ArrayList;
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
        graphics.drawImage(birdImageIcon.getImage(), x, y, this);
        // wingPositions = {birdUpFlapImageIcon, birdMidFlapImageIcon, birdDownFlapImageIcon, birdMidFlapImageIcon};
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

    public void changeSkin(int i) {
        birdColor = birdColorList[i];

        birdUpFlapImageIcon = new ImageIcon(birdColor + "bird-upflap.png");
        birdMidFlapImageIcon = new ImageIcon(birdColor + "bird-midflap.png");
        birdDownFlapImageIcon = new ImageIcon(birdColor + "bird-downflap.png");
        birdImageIcon = birdDownFlapImageIcon;
        // wingPositions = {birdUpFlapImageIcon, birdMidFlapImageIcon, birdDownFlapImageIcon, birdMidFlapImageIcon};
    }

    // public void fixY() {
    //     y -= 3;
    // }
}
