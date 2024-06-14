
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Pipe extends JPanel {
    Random random = new Random();
    ImageIcon pipeTopImageIcon = new ImageIcon("pipe-green-top.png");
    int x = 0;
    int yTop = - random.nextInt(pipeTopImageIcon.getIconHeight() - 92);
    int space = 100;
    ImageIcon pipeBottomImageIcon = new ImageIcon("pipe-green-bottom.png");
    int yBottom = yTop + pipeTopImageIcon.getIconHeight() + space;
    
    public Pipe() {
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(pipeTopImageIcon.getImage(), x, yTop, this);
        graphics.drawImage(pipeBottomImageIcon.getImage(), x, yBottom, this);
    }
}
