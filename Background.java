import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel {
    ImageIcon backgroundDayImageIcon = new ImageIcon("background-day.png");
    ImageIcon backgroundNightImageIcon = new ImageIcon("background-night.png");

    float alpha = 0f;
    float alphaChange = 0.05f;
    boolean isDay = true;

    public Background() {
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundDayImageIcon.getImage(), 0, 0, this);

        Graphics2D g2D = (Graphics2D) g;

        g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        g.drawImage(backgroundNightImageIcon.getImage(), 0, 0, this);
    }

    public void nightFall() {
        if (isDay) {
            alpha += alphaChange;
            if (alpha >= 1) {
                alpha = 1;
                isDay = false;
            }
        }
    }

    public void dayBreak() {
        if (!isDay) {
            alpha -= alphaChange;
            if (alpha <= 0) {
                alpha = 0;
                isDay = true;
            }
        }
    }
}
