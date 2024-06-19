
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

public class Start extends JLayeredPane {
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
