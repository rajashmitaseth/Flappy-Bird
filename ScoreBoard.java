
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ScoreBoard extends JPanel {
    Image Zero = new ImageIcon("0.png").getImage();
    Image One = new ImageIcon("1.png").getImage();
    Image Two = new ImageIcon("2.png").getImage();
    Image Three = new ImageIcon("3.png").getImage();
    Image Four = new ImageIcon("4.png").getImage();
    Image Five = new ImageIcon("5.png").getImage();
    Image Six = new ImageIcon("6.png").getImage();
    Image Seven = new ImageIcon("7.png").getImage();
    Image Eight = new ImageIcon("8.png").getImage();
    Image Nine = new ImageIcon("9.png").getImage();

    ArrayList<Image> scoreDigits;
    String scoreString;

    int x;

    public ScoreBoard() {
        scoreDigits = new ArrayList<>();
        // scoreDigits.add(Zero);
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Image scoreDigit : scoreDigits) {
            graphics.drawImage(scoreDigit, x, 0, this);
            x += scoreDigit.getWidth(null);
        }
        x = 0;
    }

    public void getScoreDigits(int score, int windowWidth) {
        scoreDigits.clear();
        scoreString = Integer.toString(score);
        for (int i = 0; i < scoreString.length(); i++) {
            switch (scoreString.charAt(i)) {
                case '0' -> scoreDigits.add(Zero);
                case '1' -> scoreDigits.add(One);
                case '2' -> scoreDigits.add(Two);
                case '3' -> scoreDigits.add(Three);
                case '4' -> scoreDigits.add(Four);
                case '5' -> scoreDigits.add(Five);
                case '6' -> scoreDigits.add(Six);
                case '7' -> scoreDigits.add(Seven);
                case '8' -> scoreDigits.add(Eight);
                case '9' -> scoreDigits.add(Nine);
                default -> {}
            }
        }
        getStartX(windowWidth);
    }


    int totalWidth;
    public void getStartX(int windowWidth) {
        totalWidth = 0;
        for (Image digit : scoreDigits) {
            totalWidth += digit.getWidth(null);
        }
        x = windowWidth/2 - totalWidth/2;
    }
    
}
