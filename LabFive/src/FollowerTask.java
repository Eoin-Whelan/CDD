/**
 * FollowerTask demonstrates leader task in which a thread prints a number passed to it.
 *
 * @author Eoin Farrell
 */
public class FollowerTask implements Runnable{

    /**
     * nextChar is for demonstration purposes to print the alphabetical character after the integer outputs.
     */
    public static char nextChar = 'A';

    /**
     * Instantiates a new Follower task.
     */
    public FollowerTask(){ }

    /**
     * run() performs the follower task in printing out the corresponding character
     * with the integer preceding it.
     */
    @Override
    public void run() {
        try {
            //  The FIFO queue mutex is acquired
            FifoQueue.semMutex.acquire();

            //  If there is a leader waiting, release them
            if(FifoQueue.leaderCount > 0){
                FifoQueue.leaderCount--;
                FifoQueue.leaderQ.release();
            }

            //  Otherwise, increase the follower count and join the queue.
            else{
                FifoQueue.followerCount++;
                FifoQueue.semMutex.release();
                FifoQueue.followerQ.acquire();
            }
            /*
                At this point, a follower will have been released and their
                task will complete.
             */
            System.out.print("|Follower|");
            FifoQueue.semRendezvous.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
