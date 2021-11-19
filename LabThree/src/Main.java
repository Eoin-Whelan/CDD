import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Lab 3 - Single Use/Reusable Barrier
 * Primary class for thread creation as part of demo.
 *
 * (Single-use barrier wasn't asked - was using as a base for learning the reusable one!)
 * @author Eoin Farrell - C00164354
 */
public class Main{
    static final int MAX_T = 4;
    public static void main(String[] args) {

        //  Initialize a thread pool and task list for both single and reusable barrier.
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        ArrayList<Runnable> singleUseTaskList = new ArrayList<Runnable>();
        ArrayList<Runnable> reusableTaskList = new ArrayList<Runnable>();


        System.out.println("\n\nSingle Use Demo Starting..");
        for(int i = 0; i < 4; i++){
            singleUseTaskList.add(new TaskSingleUseBarrier());
        }

        for (Runnable task : singleUseTaskList)
        {
            pool.execute(task);
        }

        //  We wait a sec before moving onto the reusable barrier demo.
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\nComplete!\n");


        System.out.println("\n\nReusable Demo Starting..\n");
        for(int i = 0; i <= 3; i++){
            reusableTaskList.add(new TaskReusableBarrier());
        }

        for (Runnable task : reusableTaskList)
        {
            pool.execute(task);
        }

        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        pool.shutdown();
    }
}

