import java.util.concurrent.Semaphore;

/**
 * Single-Use Barrier implementation
 *
 * -    Not part of lab. Used for learning purposes only.
 *
 * @author Eoin Farrell - C00164354
 */
public class TaskSingleUseBarrier implements Runnable {

    public static Semaphore mutex = new Semaphore(1);
    public static Semaphore turnstile = new Semaphore(0);
    public static Semaphore turnstileTwo = new Semaphore(1);
    public static int count = 0;
    public static int N = 4;


    public TaskSingleUseBarrier(){
    }

    @Override
    public void run() {
        try {
                mutex.acquire();
                count++;
                mutex.release();

                if (count == N) {
                    System.out.println("Turnstile One Lifted!");
                    turnstile.release();
                }
                System.out.println("A");
                turnstile.acquire();
                turnstile.release();
                System.out.println("\tB");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
