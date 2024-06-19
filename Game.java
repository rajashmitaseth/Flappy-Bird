
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JFrame implements ActionListener, KeyListener{
    Background background = new Background();
    Bird bird = new Bird();
    Base base = new Base();
    ScoreBoard scoreBoard = new ScoreBoard();
    Start startMessage = new Start();
    GameOver gameOverMessage = new GameOver();

    ArrayList<Pipe> pipes;

    int backgroundWidth = background.backgroundImageIcon.getIconWidth();
    int backgroundHeight = background.backgroundImageIcon.getIconHeight();
    int windowWidth = backgroundWidth + 16;
    int windowHeight = backgroundHeight + 39;
    int startMessageX = backgroundWidth/2 - startMessage.startMessageImageIcon.getIconWidth()/2;
    int startMessageY = backgroundHeight/2 - startMessage.startMessageImageIcon.getIconHeight()/2;
    int gameOverMessageX = backgroundWidth/2 - gameOverMessage.gameOverImage.getWidth(null)/2;
    int gameOverMessageY = backgroundHeight/2 - gameOverMessage.gameOverImage.getHeight(null)/2;
    int pipeSpacing = 3 * (backgroundWidth/2);

    Dimension windowDimension = new Dimension(windowWidth , windowHeight);
    boolean gameOver = false;
    boolean gameStarted = false;
    int score;

    Timer gameLoop;
    Timer placePipesTimer;

    public Game() {
        setTitle("Flappy Bird");
        setIconImage(bird.birdImageIcon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(windowDimension);
        setMinimumSize(windowDimension);
        setPreferredSize(windowDimension);
        setLocationRelativeTo(null);
        
        addStartMessage();
        addGameOver();
        addScoreBoard();
        addBird();
        addBase();
        addPipe();
        addBackground();

        pack();
        bird.requestFocus();
        setVisible(true);
        bird.setFocusable(true);
        bird.addKeyListener(this);

        placePipesTimer = new Timer(800, (ActionEvent e) -> {
            placePipes();
            addBackground();
        });
        gameLoop = new Timer(1000/60, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bird.move();
        movePipes();
        countScore();
        pipeSpacing -= pipes.get(0).velocityX;
        repaint();
        checkGameOver();
    }

    public void startGame() {
        placePipesTimer.start();
        gameLoop.start();
        gameOver = false;
        gameStarted = true;
        remove(startMessage);
    }

    private void addStartMessage() {
        remove(startMessage);
        startMessage.x = startMessageX;
        startMessage.y = startMessageY;
        startMessage.setBounds(0, 0, backgroundWidth, backgroundHeight);
        add(startMessage);
    }

    private void addGameOver() {
        remove(gameOverMessage);
        gameOverMessage.setBounds(gameOverMessageX, gameOverMessageY, backgroundWidth, backgroundHeight);
        add(gameOverMessage);
    }
    
    private void addBird() {
        remove(bird);
        bird.x = backgroundWidth/2 - bird.birdImageIcon.getIconWidth()/2;
        bird.y = backgroundHeight/2 + 36;
        bird.setBounds(0, 0, backgroundWidth, backgroundHeight);
        add(bird);
    }

    private void addScoreBoard() {
        remove(scoreBoard);
        scoreBoard.setBounds(0, scoreBoard.Zero.getHeight(null), backgroundWidth, backgroundHeight);
        add(scoreBoard);
    }

    private void addPipe() {
        pipes = new ArrayList<>();
        Pipe pipeNew = new Pipe();
        pipeNew.x = pipeSpacing;
        pipeNew.setBounds(0, 0, backgroundWidth, backgroundHeight);
        add(pipeNew);
        pipeSpacing += backgroundWidth/2;
        pipes.add(pipeNew);
    }

    private void addBackground() {
        remove(background);
        background.setBounds(0, 0, backgroundWidth, backgroundHeight - base.baseImageIcon.getIconHeight());
        add(background);
    }

    private void addBase() {
        remove(base);
        base.y = backgroundHeight - base.baseImageIcon.getIconHeight();
        base.setBounds(0, 0, windowWidth, windowHeight);
        add(base);
    }

    public void placePipes() {
        Pipe pipeNew = new Pipe();
        pipeNew.x = pipeSpacing;
        pipeNew.setBounds(0, 0, backgroundWidth, backgroundHeight);
        add(pipeNew);
        pipeSpacing += backgroundWidth/2;
        pipes.add(pipeNew);
    }

    public void movePipes() {
        for (Pipe pipe : pipes) {
            pipe.move();
            checkHit(pipe);
        }
        if(bird.x > backgroundWidth/8) {
            bird.fixX();
        }
    }

    public void checkHit(Pipe p) {
        if(p.x + p.pipeTopImageIcon.getIconWidth() > bird.x  &&  
          ((bird.x + bird.birdImageIcon.getIconWidth() >= p.x  &&  bird.y <= p.yTop + p.pipeTopImageIcon.getIconHeight())  ||
           (bird.x + bird.birdImageIcon.getIconWidth() >= p.x  &&  bird.y + bird.birdImageIcon.getIconHeight() >= p.yBottom))) {
            gameOver = true;
        }
        else if(p.x + p.pipeTopImageIcon.getIconWidth() < bird.x){
            p.passed = true;
        }
        else if(bird.y == 0 || bird.y + bird.birdImageIcon.getIconHeight() == backgroundHeight) {
            gameOver = true;
        }
    }

    public void countScore() {
        score = 0;
        for (Pipe pipe : pipes) {
            if (pipe.passed) {
                score += 1;
            }            
        }            
        scoreBoard.getScoreDigits(score, backgroundWidth);
    }        

    public void checkGameOver() {
        if(gameOver) {
            placePipesTimer.stop();
            gameLoop.stop();
            gameOverMessage.setVisible(true);
            gameStarted = false;
        }
    }

    public void resetGameFrame() {
        for (Pipe pipe : pipes) {
            remove(pipe);
        }
        pipes.clear();
        pipeSpacing = 3 * (backgroundWidth/2);
        bird.y = windowHeight/2;
        gameOver = false;
        score = 0;
        gameOverMessage.setVisible(false);

        addStartMessage();
        addGameOver();
        addScoreBoard();
        addPipe();
        addBackground();
        countScore();

        bird.x = backgroundWidth/2 - bird.birdImageIcon.getIconWidth()/2;
        bird.y = backgroundHeight/2 + 36;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            bird.velocityY = -9;
            if(gameOver) {
                resetGameFrame();
            }
            else if(!gameStarted && !gameOver) {
                startGame();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}