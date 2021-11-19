import java.util.concurrent.Semaphore;

public class WaitingTask implements Runnable {

    IntegerObj passedInteger;
    Semaphore sem;
    public WaitingTask(IntegerObj passedInteger, Semaphore sem){

        this.sem = sem;
        this.passedInteger = passedInteger;
    }


    @Override
    public void run() {
        synchronized(sem){
            try {
                System.out.println("Waiting task has started!");
                sem.acquire();
                passedInteger.inc();
                System.out.println("Waiting task complete!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
