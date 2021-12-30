package lab.six;

import java.nio.CharBuffer;
import java.util.concurrent.Semaphore;

/**
 * Buffer class for taking/outputting Producer/Consumer calls
 * @author Eoin Farrell
 */
public class Buffer {

    /**
     * The constant buffer.
     *
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/nio/CharBuffer.html">CharBuffer</a><br>
     *     buffer acts as a storage for characters stored by Producer and outputted by Consumer's run() calls,
     *     respectively.<br><br>
     *
     *     Max of ten characters may be stored on a buffer.
     */
    static CharBuffer buffer = CharBuffer.allocate(10);

    /**
     * bufferMutex secures access to only one thread at a time to interact with the buffer.
     */
    static Semaphore bufferMutex = new Semaphore(1);

    /**
     * itemSem acts as a flag for the consumer to awaken when there are items in the buffer.
     */
    static Semaphore itemSem = new Semaphore(0);

    /**
     * spaceSem acts as the flag to indicate space exists on the buffer for the producer to know when
     * to cease adding elements until a consumer has performed an output.
     */
    static Semaphore spaceSem = new Semaphore(10);


    /**
     * Instantiates a new Buffer.
     */
    public Buffer(){}

    /**
     * get() method is exclusively called by consumer class. It outputs the
     * contents of the buffer.
     */
    public static void get(){

        try {
            //  Marks the latest input position.
            int stoppingPoint = buffer.position();
            //  Resets the buffer's ptr
            buffer.rewind();
            //  Outputs the entirety of the buffer
            while (buffer.position() != stoppingPoint) {
                System.out.println(buffer.position() + " -> " + buffer.get());

                //  The spaceSem is here in the consumption process in order to clear the
                //  buffer.
                spaceSem.release();
            }
            //  The buffer is then cleared to allow producers to place new elements.
            buffer.clear();
        }
        catch(Exception e){
            System.out.println("get() exception: " + e.fillInStackTrace());
        }
    }

    /**
     * put() method is exclusively called by the producer class to
     * add characters to the buffer for consumption.
     * @param input the input
     */
    public static void put(char input){
        try{
            buffer.put(input);
        }
        catch(Exception e){
            System.out.println("put() exception: " + e.fillInStackTrace());
        }

    }
}
