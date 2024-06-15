import java.util.ArrayList;

public class PipeController {
    ArrayList<Pipe> pipes = new ArrayList<>();
    int velocityX = 4;
    
    public PipeController() {
        
    }

    public void move() {
        for (Pipe pipe: pipes) {
            pipe.x -= velocityX;
        }
    }

    public void createPipeList() {
        for(int i = 0; i < 3; i++) {
            pipes.add(new Pipe());
        }
    }
}
