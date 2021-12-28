import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * Fifo queue of static attributes to act for:
 * i)   counter
 * ii)  mutex, rendezvous and leader/follower queue semaphores.
 *
 * Class is declared statically in order for both Leader and Follower tasks to interact with shared locks.
 * @author Eoin Farrell
 */
public class FifoQueue {
    public static int leaderCount, followerCount = 0;

    /**
     * semMutex protects the queue.
     */
    public static Semaphore semMutex = new Semaphore(1);
    /**
     * For permitting the leader/follower to perform their tasks alongside one another.
     */
    public static Semaphore semRendezvous = new Semaphore(0);

    /**
     * Queue semaphore for leader
     */
    public static Semaphore leaderQ = new Semaphore(0);

    /**
     * Queue semaphore for follower
     */
    public static Semaphore followerQ = new Semaphore(0);

}
