/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.two;

import java.util.concurrent.Semaphore;

/**
 * IntegerObj class for thread demonstration. Allows for single Integer memory reference to be modified.
 * @author KEHOEJ
 * @author Eoin Farrell (Documentation and Synchronization implementation)
 */
class IntegerObj {
    static Semaphore mutex = new Semaphore(1);
    int value;
    IntegerObj(int val) {
        this.value = val;
    }

    /**
     * inc() increments the total value of class int variable value. Method has been modified to use the synchronized
     * keyword, allowing for java's internal thread synchronization monitor lock structure to allow for single-thread
     * access to the method.
     * @return new value for value integer.
     */
    synchronized int inc(){
            //mutex.acquire();
        this.value++;
            //mutex.release();

        return this.value;
    }
}
