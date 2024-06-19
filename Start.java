
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Start extends JPanel {
    ImageIcon startMessageImageIcon = new ImageIcon("message.png");

    JButton yellowBirdButton = new JButton(new ImageIcon("yellowbird-downflap.png"));
    JButton redBirdButton = new JButton(new ImageIcon("redbird-downflap.png"));
    JButton blueBirdButton = new JButton(new ImageIcon("bluebird-downflap.png"));

    int x = 0;
    int y = 0;

    public Start() {
        setVisible(true);

        yellowBirdButton.setToolTipText("Yellow bird");
        redBirdButton.setToolTipText("Red bird");
        blueBirdButton.setToolTipText("Blue bird");

        yellowBirdButton.setFocusable(false);
        redBirdButton.setFocusable(false);
        blueBirdButton.setFocusable(false);

        yellowBirdButton.setBackground(new Color(0xffcc50));
        redBirdButton.setBackground(new Color(0xfc7407));
        blueBirdButton.setBackground(new Color(0x4dc7fc));
        
        
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(startMessageImageIcon.getImage(), x, y, this);
    }
}
