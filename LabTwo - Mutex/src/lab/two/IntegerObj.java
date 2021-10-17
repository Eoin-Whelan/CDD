/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.two;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * IntegerObj class for thread demonstration. Allows for single Integer memory reference to be modified.
 * @author KEHOEJ
 * @author Eoin Farrell (Documentation & Synchronization implementation)
 */
class IntegerObj {
    static Semaphore mutex = new Semaphore(1);
    AtomicInteger value = new AtomicInteger(0);
    IntegerObj(int val) {
        this.value = val;
    }

    /**
     * inc() increments the total value of class int variable value. Method has been modified to implement an above
     * static semaphore to allow for mutual exclusion via mutex lock. Once invoked, the calling thread acquires the
     * semaphore, performs the increment and releases the lock to allow other threads to perform their increment.
     * @return new value for value integer.
     */
    int inc(){
        try {
            mutex.acquire();
            this.value++;
            mutex.release();
        }
        catch(Exception e){
        }
        return this.value;
    }
}
