
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
    ScoreBoard scoreBoard = new ScoreBoard();

    ArrayList<Pipe> pipes;

    Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int)screenDimension.getWidth();
    int screenHeight = (int)screenDimension.getHeight();
    int windowWidth = 336;
    int windowHeight = 709;
    Dimension windowDimension = new Dimension(windowWidth, windowHeight);
    int windowX = screenWidth/2 - windowWidth/2;
    int windowY = screenHeight/2 - windowHeight/2;
    int pipeSpacing = windowWidth;
    int pipeStartX;
    int pipeEndX;
    int pipeStartY;
    int topPipeEnd;
    int bottomPipeStart;
    boolean gameOver;
    int score;

    Timer gameLoop;
    Timer placePipesTimer;

    public Game() {

        setTitle("Flappy Bird");
        setIconImage(bird.birdImageIcon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowWidth, windowHeight);
        setMinimumSize(windowDimension);
        setLocation(windowX, windowY);

        bird.setBounds(windowWidth/8, 0, bird.birdImageIcon.getIconWidth(), bg.backgroundImageIcon.getIconHeight());
        add(bird);

        scoreBoard.setBounds(0, scoreBoard.Zero.getHeight(null), windowWidth, windowHeight);
        add(scoreBoard);

        pipes = new ArrayList<>();
        Pipe pipeNew = new Pipe();
        pipeNew.x = pipeSpacing;
        pipeNew.setBounds(0, 0, windowWidth, bg.backgroundImageIcon.getIconHeight());
        add(pipeNew);
        pipeSpacing += windowWidth/2;
        pipes.add(pipeNew);

        addBackground();

        base.y = bg.backgroundImageIcon.getIconHeight();
        base.setBounds(0, bg.backgroundImageIcon.getIconHeight(), base.baseImageIcon.getIconWidth(), base.baseImageIcon.getIconHeight());
        add(base);

        pack();
        bird.requestFocus();
        setVisible(true);

        placePipesTimer = new Timer(800, (ActionEvent e) -> {
            removeBackground();
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
        countScore();
        pipeSpacing -= pipes.get(0).velocityX;
        repaint();
        birdOutOfBounds();
        checkGameOver();
    }

    public void countScore() {
        score = 0;
        for (Pipe pipe : pipes) {
            if (pipe.passed) {
                score += 1;
            }
        }
        scoreBoard.getScoreDigits(score, windowWidth);
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
            checkHit(pipe);
        }
    }

    private void addBackground() {
        bg.setBounds(0, 0, bg.backgroundImageIcon.getIconWidth(), bg.backgroundImageIcon.getIconHeight());
        add(bg);
    }

    public void removeBackground() {
        remove(bg);
    }

    public void checkHit(Pipe p) {
        pipeStartX = p.x;
        pipeEndX = pipeStartX + p.pipeTopImageIcon.getIconWidth();
        pipeStartY = p.yTop;
        topPipeEnd = pipeStartY + p.pipeTopImageIcon.getIconHeight();
        bottomPipeStart = p.yBottom;
        if(pipeEndX > windowWidth/8  &&  
           ((windowWidth/8 + bird.birdImageIcon.getIconWidth() >= pipeStartX  &&  bird.y <= topPipeEnd)  ||
            (windowWidth/8 + bird.birdImageIcon.getIconWidth() >= pipeStartX  &&  bird.y + bird.birdImageIcon.getIconHeight() >= bottomPipeStart))) {
            gameOver = true;
        }
        else if(pipeEndX < windowWidth/8){
            p.passed = true;
        }
    }

    public void birdOutOfBounds() {
        if(bird.y == 0 || bird.y + bird.birdImageIcon.getIconHeight() == bg.backgroundImageIcon.getIconHeight()) {
            gameOver = true;
        }
    }

    public void checkGameOver() {
        if(gameOver) {
            placePipesTimer.stop();
            gameLoop.stop();
        }
    }

}
