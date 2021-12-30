package lab.six;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Demonstration class for the Producer/Consumer lab.
 *
 * Program spins up producer and consumer tasks to feed and output a series of characters for demo purposes.
 *
 * <br><br>
 *  Sample output is as such<br>
 * Producer adding: D<br>
 * Producer adding: E<br>
 * Consumer Producing<br>
 * 0 - D<br>
 * 1 - E<br>
 */
public class Main {

    public static final int MAX_T = 8;
    public static void main(String[] args) {


        //  Loop for initializing lists of follower/leader tasks. Thread pool initialized also.
        Buffer buffer = new Buffer();

        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);


        //  The following are a series of Producer and Consumer tasks instantiated
        //  and executed for demo purposes.
        pool.execute(new Producer());
        pool.execute(new Producer());
        pool.execute(new Producer());

        wait(1000);


        pool.execute(new Consumer());

        wait(500);

        pool.execute(new Producer());
        pool.execute(new Producer());

        wait(1000);

        pool.execute(new Consumer());



        pool.execute(new Producer());
        pool.execute(new Producer());
        pool.execute(new Producer());
        pool.execute(new Producer());
        pool.execute(new Producer());
        pool.execute(new Producer());
        pool.execute(new Producer());
        pool.execute(new Producer());

        wait(1000);

        pool.execute(new Consumer());

        pool.execute(new Producer());
        pool.execute(new Producer());
        pool.execute(new Consumer());



        wait(1000);


        pool.shutdown();

    }

    /**
     * wait exists to tidy up the number of times a thread sleep method was called throughout the demo.
     * @param mil
     */
    public static void wait(int mil){
        try {
            Thread.sleep(mil);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
