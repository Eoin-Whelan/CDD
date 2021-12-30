package lab.six;

import java.util.concurrent.Semaphore;

/**
 * Producer class that places the character on the buffer.
 * @author Eoin Farrell
 */
public class Producer implements Runnable{

    /**
     * producingChar is the "starting point" for demo purposes.
     */
    static char producingChar = 'A';

    /**
     * run() creates the "event" for the consumer to work from.
     */
    @Override
    public void run() {
        try {

            Buffer.spaceSem.acquire();
            Buffer.bufferMutex.acquire();

            //  "Event" Creation
            System.out.println("Producer adding: " + producingChar);
            Buffer.put(producingChar);
            producingChar++;

            Buffer.bufferMutex.release();
            Buffer.itemSem.release();

        }
        catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }
}
