import java.util.concurrent.Semaphore;

/**
 * LeaderTask demonstrates leader task in which a thread prints a number passed to it.
 * @author Eoin Farrell
 */
public class LeaderTask implements Runnable {

    /**
     * nextNum is for demo purposes to print the integer associated with the alphabetical character.
     */
    public int nextNum;
    public LeaderTask(int nextNum){
        this.nextNum = nextNum;
    }

    //public Semaphore taskSem = new Semaphore(1////);

    /**
     * run() performs the follower task in printing out the corresponding character
     * with the integer preceding it.
     */
    @Override
    public void run() {
        try {
            //  The FIFO queue mutex is acquired
            FifoQueue.semMutex.acquire();

            //  If there is a follower waiting, release it
            if(FifoQueue.followerCount > 0){
                FifoQueue.followerCount--;
                FifoQueue.followerQ.release();
            }
            //  Otherwise, begin waiting but release the mutex so a follower
            //  May release the waiting leader.
            else{
                FifoQueue.leaderCount++;
                FifoQueue.semMutex.release();
                FifoQueue.leaderQ.acquire();
            }

            //  Acquire the rendezvous to await a follower
            FifoQueue.semRendezvous.acquire();
            //  Output task
            System.out.print("Leader|\t");
            System.out.println("Task: " + nextNum + " Complete");

            //  Release the hold a follower will have put on the queue's mutex.
            FifoQueue.semMutex.release();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
