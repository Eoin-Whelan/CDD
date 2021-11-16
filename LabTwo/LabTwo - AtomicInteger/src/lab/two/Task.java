/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.two;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * IntegerObj class for thread demonstration. Uses AtomicInteger for incrementing, eliminating the need for IntegerObj.
 * @author joe
 * @author Eoin Farrell (Documentation and Synchronization implementation)
 * */
public class Task implements Runnable {
private String name;
    private AtomicInteger total;
    public Task(String task_1, AtomicInteger total) {
        name=task_1;
        this.total = total;
    }

    /**
     * run() performs increment on AtomicInteger passed. Rather than use an integer obj, the use of the new class
     * attribute of an AtomicInteger allows the task to perform as intended (i.e. count to 2000) without the need
     * for the IntegerObj class. AtomicInteger is capable of incrementing concurrently without the need to worry
     * about each thread performing the increment operation causing a race condition scenario.
     */
    public void run()
    {
        try
        {
            for (int i = 0; i<500; i++)
            {
                total.addAndGet(1);
                if (i%100==0){
                   Thread.sleep(100); 
                }
            }
            System.out.println(name+" complete");
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
