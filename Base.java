import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Base extends JPanel {
    ImageIcon baseImageIcon = new ImageIcon("base.png");
    int x = 0;
    int y = 0;
    
    public Base() {
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(baseImageIcon.getImage(), x, y, this);
    }
}
