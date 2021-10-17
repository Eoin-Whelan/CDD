/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.two;

import java.util.concurrent.Semaphore;

/**
 *
 * @author joe
 */
class IntegerObj {
    static Semaphore mutex = new Semaphore(1);
    int value;
    IntegerObj(int val) {
        this.value = val;
    }
    synchronized int inc(){
            //mutex.acquire();
        this.value++;
            //mutex.release();

        return this.value;
    }
}
