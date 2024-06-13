import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel {
    ImageIcon backgroundImageIcon = new ImageIcon("background-day.png");

    public Background() {
        setVisible(true);
        setSize(360, 640);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(backgroundImageIcon.getImage(), 0, 0, this);
    }

}
