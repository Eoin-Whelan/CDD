import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{
    static final int MAX_T = 4;
    public static void main(String[] args) {
        int charStartingPoint = 65;
        int numStartingPoint = 1;
        ArrayList<LeaderTask> leaderTasks = new ArrayList<LeaderTask>();
        ArrayList<FollowerTask> followerTasks = new ArrayList<FollowerTask>();
        for(int i = 1; i <= 26; i++){
            leaderTasks.add(new LeaderTask(i));
            followerTasks.add(new FollowerTask(charStartingPoint));
            charStartingPoint++;
        }
        //LeaderTask lTask1 = new LeaderTask(startingPoint);
        //FollowerTask fTask1 = new FollowerTask(startingPoint);

        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        for(int i = 0; i < leaderTasks.size();i++){
            pool.execute(leaderTasks.get(i));
            pool.execute(followerTasks.get(i));
        }
        pool.shutdown();
    }
}

