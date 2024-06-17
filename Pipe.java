
import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Pipe extends JPanel {
    Random random = new Random();
    ImageIcon pipeTopImageIcon = new ImageIcon("pipe-green-top.png");
    ImageIcon pipeBottomImageIcon = new ImageIcon("pipe-green-bottom.png");
    int x = 0;
    int space = 100;
    int yTop = - random.nextInt(pipeTopImageIcon.getIconHeight() - 177);
    int yBottom = yTop + pipeTopImageIcon.getIconHeight() + space;
    boolean passed = false;
    int velocityX = 4;
    
    public Pipe() {
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(pipeTopImageIcon.getImage(), x, yTop, this);
        graphics.drawImage(pipeBottomImageIcon.getImage(), x, yBottom, this);
    }

    public void move() {
        x -= velocityX;
    }
}
