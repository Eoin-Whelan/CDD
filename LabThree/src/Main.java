import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{
    static final int MAX_T = 4;
    public static void main(String[] args) {

        ArrayList<Task> taskList = new ArrayList<Task>();
        for(int i = 1; i <= 4; i++){
            //leaderTasks.add(new LeaderTask(i));
            taskList.add(new Task(i));
        }

        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        for(int i = 0; i < taskList.size();i++){
            //pool.execute(leaderTasks.get(i));
            pool.execute(taskList.get(i));
        }
        pool.shutdown();
    }
}

