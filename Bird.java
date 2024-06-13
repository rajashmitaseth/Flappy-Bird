import javax.swing.*;
// import java.awt.*;

public class Bird extends JPanel{
    ImageIcon birdImage = new ImageIcon("yellowbird-midflap.png");

    public  Bird() {
        add(new JLabel(birdImage));
    }

    // public void draw() {
    //     setLocation(77, 55);
    // }
}
