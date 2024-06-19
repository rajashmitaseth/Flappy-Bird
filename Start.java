
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Start extends JPanel {
    ImageIcon startMessageImageIcon = new ImageIcon("message.png");
    int x = 0;
    int y = 0;

    public Start() {
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(startMessageImageIcon.getImage(), x, y, this);
    }
}
