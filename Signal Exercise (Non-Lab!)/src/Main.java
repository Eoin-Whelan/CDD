import sun.misc.Signal;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Basic Exercise to understand basic signalling in semaphores.
 *
 * This program creates two tasks, where SignallingTask must complete
 * before WaitingTask can properly begin.
 *
 * The purpose is to exemplify how a single shared semaphore can be used
 * to synchronize the two tasks appropriately.
 * @author: Eoin Farrell C00164354
 */
public class Main{

    //  Establish a thread pool w/ two threads max.
    static final int MAX_T = 2;
    public static void main(String[] args) {

        //  We initialize an IntegerObj and semaphore to 0.
        IntegerObj num = new IntegerObj(0);
        Semaphore sem = new Semaphore(0);

        //  Initialize the tasks.
        Runnable taskOne = new SignallingTask(num, sem);
        Runnable taskTwo = new WaitingTask(num, sem);
        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        //  Execute tasks
        pool.execute(taskOne);
        pool.execute(taskTwo);

        //  We sleep a wee bit to let the threads complete and show the integerObj is now 2.
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Final Value: " + num.value);
        pool.shutdown();
    }
}

