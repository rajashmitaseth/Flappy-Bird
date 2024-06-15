
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JFrame implements ActionListener{
    Background bg = new Background();
    Bird bird = new Bird();
    Base base = new Base();
    PipeController pipeController = new PipeController();

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
    Timer placePipeTimer;

    public Game() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setMinimumSize(windowDimension);
        setLocation(windowX, windowY);

        bird.setBounds(windowWidth/8, 0, bird.birdImageIcon.getIconWidth(), bg.backgroundImageIcon.getIconHeight());
        add(bird);

        pipeController.createPipeList();
        placePipes();
        bg.setBounds(0, 0, bg.backgroundImageIcon.getIconWidth(), bg.backgroundImageIcon.getIconHeight());
        add(bg);

        base.y = bg.backgroundImageIcon.getIconHeight();
        base.setBounds(0, bg.backgroundImageIcon.getIconHeight(), base.baseImageIcon.getIconWidth(), base.baseImageIcon.getIconHeight());
        add(base);

        pack();
        bird.requestFocus();
        setVisible(true);

        gameLoop = new Timer(1000/60, this);
        
        placePipeTimer = new Timer(1000, placePipePerformer);
        placePipeTimer.start();

        gameLoop.start();
    }

    ActionListener placePipePerformer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            addPipes();
            System.out.println(pipeController.pipes.size() + "th Pipe added.\n");
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.move();
        pipeController.move();
        pipeSpacing = pipeSpacing - pipeController.velocityX;
        repaint();
    }

    public void placePipes() {
        // pipeController.createPipeList();
        for(Pipe pipe: pipeController.pipes) {
            pipe.x = pipeSpacing;
            pipe.setBounds(0, 0, windowWidth, bg.backgroundImageIcon.getIconHeight());
            add(pipe);
            pipeSpacing += windowWidth/2;
        }
    }

    public void addPipes() {
        pipeController.pipes.add(new Pipe());
        Pipe pipeTemp = pipeController.pipes.get(pipeController.pipes.size() - 1);
        pipeTemp.x = pipeSpacing;
        pipeTemp.setBounds(0, 0, windowWidth, bg.backgroundImageIcon.getIconHeight());
        add(pipeTemp);
        pipeSpacing += windowWidth/2;
    }
}
