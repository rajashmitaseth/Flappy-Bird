import javax.swing.*;
import java.awt.*;

public class Bg extends JPanel{
    ImageIcon backgroundImage;
    
    public Bg() {
        backgroundImage = new ImageIcon("background-day.png");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
    }
}
