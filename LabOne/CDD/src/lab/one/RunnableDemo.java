/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.one;

/**
 * The type Runnable demo.
 *
 * Primary class for thread creation as part of CDD threading demo. Uses Java's Runnable interface in order to execute via threading.
 *
 * @author KEHOEJ
 * @author Eoin Farrell (Documentation)
 */
class RunnableDemo implements Runnable {
   private Thread t;
   private String threadName;

   /**
    * Instantiates a new Runnable demo.
    *
    * @param name the desired name of the thread generated.
    */
   RunnableDemo( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }

   /**
    * Internally called method to run upon a start() invocation.
    * @see  InterruptedException (https://docs.oracle.com/javase/7/docs/api/java/lang/InterruptedException.html)
    */
   @Override
   public void run() {
      System.out.println("Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
      } catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }

   /**
    * Main accessor for class to generate threaded task.
    */
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
