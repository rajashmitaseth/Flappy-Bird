import java.util.TimerTask;

public class AddToPipeList extends TimerTask{
    PipeController pipeController = new PipeController();
    
    @Override
    public void run() {
        pipeController.pipes.add(new Pipe());
    }
}
