package lab.six;

/**
 * Consumer class that calls the buffer method to output and clear it's contents.
 * <br><br>
 * This acts as the processing of "events" in which characters are added to the buffer by
 * the Producer class.
 * @author Eoin Farrell
 */
public class Consumer implements Runnable {

    /**
     * run() processes the "events" added to the buffer.
     */
    @Override
    public void run() {

        try {
            Buffer.itemSem.acquire();
            Buffer.bufferMutex.acquire();
            System.out.println("Consumer Outputting Buffer Contents");

            Buffer.get();

            Buffer.bufferMutex.release();
        }
        catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }
}
