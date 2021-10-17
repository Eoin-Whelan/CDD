/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.two;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Task class for thread demonstration
 *
 * @author KEHOEJ
 * @author Eoin Farrell (Documentation)
 */
public class Task implements Runnable {
    private String name;
    private IntegerObj total;

    /**
     * Instantiates a new Task.
     *
     * @param task_1 the task 1
     * @param total  the total
     */
    public Task(String task_1, IntegerObj total) {
        name=task_1;
        this.total = total;
    }

    /**
     * run calls inc method on IntegerObj class variable 500 times,
     * sleeping for 100 milliseconds on each 1/10 of a second interval.
     * By end of task, total's "total" value has 500 added.
     */
    public void run()
    {
        try
        {
            for (int i = 0; i<500; i++)
            {
                total.inc();
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
