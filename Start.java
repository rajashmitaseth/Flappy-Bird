
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Start extends JPanel {
    ImageIcon startMessageImageIcon = new ImageIcon("message.png");

    public Start() {
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(startMessageImageIcon.getImage(), 0, 0, this);
    }
}
