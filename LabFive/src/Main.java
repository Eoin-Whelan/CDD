import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class demonstrating Follower/Leader pattern in concurrency.
 *
 * Program prints integer and correlating alphabetical character associated with it.
 *
 * <br><br>
 * An assumption is made around the output that the follower task is executing first given it's
 * release by the leader task during rendezvous.
 * <br><br>
 * Sample output is as such<br>
 *     |Follower|Leader| Task x is Complete.
 * @author Eoin Farrell
 */
public class Main {

    /**
     * Max no. of threads
     */
    static final int MAX_T = 8;

    public static void main(String[] args) {

        //  List of leader/follower tasks to perform operations.
        ArrayList<LeaderTask> leaderTasks = new ArrayList<>();
        ArrayList<FollowerTask> followerTasks = new ArrayList<>();

        //  Loop for initializing lists of follower/leader tasks. Thread pool initialized also.
        for (int i = 1; i <= 50; i++) {
            leaderTasks.add(new LeaderTask(i));
            followerTasks.add(new FollowerTask());
        }

        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        //  Pool of threads are executed for demo purposes.
        for (int i = 0; i <= 49; i++) {
            pool.execute(leaderTasks.get(i));
            pool.execute(followerTasks.get(i));
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        pool.shutdown();


    }
}

