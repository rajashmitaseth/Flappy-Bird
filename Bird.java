
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Bird extends JPanel implements KeyListener{
    Background background = new Background();
    ImageIcon birdUpFlapImageIcon = new ImageIcon("yellowbird-upflap.png");
    ImageIcon birdMidFlapImageIcon = new ImageIcon("yellowbird-midflap.png");
    ImageIcon birdDownFlapImageIcon = new ImageIcon("yellowbird-downflap.png");
    ImageIcon birdImageIcon = birdUpFlapImageIcon;
    ImageIcon[] wingPositions = {birdUpFlapImageIcon, birdMidFlapImageIcon, birdDownFlapImageIcon, birdMidFlapImageIcon};
    int wingPosition = 0;
    int x = 0;
    int y = background.backgroundImageIcon.getIconHeight()/2;
    int velocityY = 0;
    float gravity = 1f;
    
    public Bird() {
        setVisible(true);
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics graphics) {
        this.flap();
        graphics.drawImage(birdImageIcon.getImage(), x, y, this);
    }

    public void move() {
        velocityY += gravity;
        y += velocityY;
        y = Math.min(y, background.backgroundImageIcon.getIconHeight() - birdImageIcon.getIconHeight());
        y = Math.max(y, 0);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            velocityY = -9;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public void flap() {
        birdImageIcon = wingPositions[wingPosition];
        wingPosition++;
        if (wingPosition > 3) {
            wingPosition = 0;
        }
    }
}
