
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

        pipes = new ArrayList<Pipe>();
        placePipes();
        placePipes();

        addBackground();

        base.y = bg.backgroundImageIcon.getIconHeight();
        base.setBounds(0, bg.backgroundImageIcon.getIconHeight(), base.baseImageIcon.getIconWidth(), base.baseImageIcon.getIconHeight());
        add(base);

        pack();
        bird.requestFocus();
        setVisible(true);

        placePipesTimer = new Timer(1000, (ActionEvent e) -> {
            placePipes();
            addBackground();
        });
        placePipesTimer.start();

        gameLoop = new Timer(1000/60, this);
        gameLoop.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.move();
        movePipes();
        pipeSpacing -= pipes.get(0).velocityX;
        repaint();
    }

    public void placePipes() {
        Pipe pipeNew = new Pipe();
        pipeNew.x = pipeSpacing;
        pipeNew.setBounds(0, 0, windowWidth, bg.backgroundImageIcon.getIconHeight());
        add(pipeNew);
        pipeSpacing += windowWidth/2;
        pipes.add(pipeNew);
    }

    public void movePipes() {
        for (Pipe pipe : pipes) {
            pipe.move();
        }
    }

    public void addBackground() {
        bg.setBounds(0, 0, bg.backgroundImageIcon.getIconWidth(), bg.backgroundImageIcon.getIconHeight());
        add(bg);
    }

}
