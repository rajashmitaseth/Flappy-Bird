
import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Pipe extends JPanel {
    Random random = new Random();
    ImageIcon pipeTopImageIcon = new ImageIcon("pipe-green-top.png");
    ImageIcon pipeBottomImageIcon = new ImageIcon("pipe-green-bottom.png");
    int x = 0;
    int space = 150;
    int yTop = - random.nextInt(270, pipeTopImageIcon.getIconHeight() - 30);
    int yBottom = yTop + pipeTopImageIcon.getIconHeight() + space;
    boolean passed = false;
    int velocityX = 3;
    
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
