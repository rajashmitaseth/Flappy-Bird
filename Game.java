
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JFrame implements ActionListener{
    Background bg = new Background();
    Bird bird = new Bird();
    Base base = new Base();
    // Pipe pipe1 = new Pipe();
    // Pipe pipe2 = new Pipe();

    ArrayList<Pipe> pipes;

    Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int)screenDimension.getWidth();
    int screenHeight = (int)screenDimension.getHeight();
    int windowWidth = 336;
    int windowHeight = 709;
    Dimension windowDimension = new Dimension(windowWidth, windowHeight);
    int windowX = screenWidth/2 - windowWidth/2;
    int windowY = screenHeight/2 - windowHeight/2;
    int pipeSpacing = windowWidth/2;

    Timer gameLoop;
    Timer placePipesTimer;

    public Game() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setMinimumSize(windowDimension);
        setLocation(windowX, windowY);

        bird.setBounds(windowWidth/8, 0, bird.birdImageIcon.getIconWidth(), bg.backgroundImageIcon.getIconHeight());
        add(bird);
        
        bg.setBounds(0, 0, bg.backgroundImageIcon.getIconWidth(), bg.backgroundImageIcon.getIconHeight());
        add(bg);

        base.y = bg.backgroundImageIcon.getIconHeight();
        base.setBounds(0, bg.backgroundImageIcon.getIconHeight(), base.baseImageIcon.getIconWidth(), base.baseImageIcon.getIconHeight());
        add(base);

        pack();
        bird.requestFocus();
        setVisible(true);

        gameLoop = new Timer(1000/60, this);
        gameLoop.start();

        placePipesTimer = new Timer(1500, (ActionEvent e) -> {
            placePipes();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.move();
        repaint();
    }

    public void placePipes() {
        Pipe pipe = new Pipe();
        pipes.add(pipe);
    }

}