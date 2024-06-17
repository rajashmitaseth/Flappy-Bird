
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameOver extends JPanel {
    Image gameOverImage = new ImageIcon("gameover.png").getImage();

    public GameOver() {
        setVisible(false);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(gameOverImage, 0, 0, this);
    }
}
