import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel {
    ImageIcon backgroundImageIcon = new ImageIcon("background-day.png");
    int x = 0;
    int y = 0;

    public Background() {
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(backgroundImageIcon.getImage(), x, y, this);
    }

}
