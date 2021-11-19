import java.util.concurrent.Semaphore;


/**
 * Reusable Barrier implementation
 *
 * @author Eoin Farrell - C00164354
 */
public class TaskReusableBarrier implements Runnable {

    /** Mutex semaphore for a shared (static) counter. */
    public static Semaphore mutex = new Semaphore(1);

    /** 2x Turnstile semaphores for barrier reusability */
    public static Semaphore turnstile = new Semaphore(0);
    public static Semaphore turnstileTwo = new Semaphore(1);

    /** Count variable as part of barrier lift/block operations */
    public static int count = 0;

    /** N for number of threads executing in this code block */
    public static int N = 4;

    public TaskReusableBarrier(){ }

    /**
     *  run() operation demonstrates a barrier's functionality in that N threads must reach
     *  a shared point before they continue.
     */
    @Override
    public void run() {
        for(int i = 0; i < 2; i++){
            try {
                mutex.acquire();
                count++;
                if (count == N) {
                    turnstileTwo.acquire();
                    turnstile.release();
                }
                mutex.release();

                turnstile.acquire();
                turnstile.release();

                System.out.println("A");


                mutex.acquire();
                count--;
                if (count == 0) {
                    turnstile.acquire();
                    turnstileTwo.release();
                }
                mutex.release();

                turnstileTwo.acquire();
                turnstileTwo.release();
                System.out.println("\tB");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
