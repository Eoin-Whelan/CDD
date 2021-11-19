import java.util.concurrent.Semaphore;

public class SignallingTask implements Runnable {

    Semaphore sem;
    IntegerObj passedNum;
    public SignallingTask(IntegerObj passedNum, Semaphore sem){

        this.passedNum = passedNum;
        this.sem = sem;
    }

    @Override
    public void run() {
        synchronized(sem){
            try{
                System.out.println("Starting task!");
                passedNum.inc();
                sem.release();
                System.out.println("Starting task complete!");
            }
            catch (Exception e){
                System.out.println(e.fillInStackTrace());
            }
        }
    }
}