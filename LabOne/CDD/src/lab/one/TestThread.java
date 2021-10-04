/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.one;

/**
 * Demonstration class for RunnableDemo thread class.
 *
 * Upon initialization, main() generates two RunnableDemo instances and invokes their implementation of start().
 *
 * @author KEHOEJ
 * @author Eoin Farrell (Documentation)
 */
public class TestThread {
    public static void main(String args[]) {
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        R1.start();
        RunnableDemo R2 = new RunnableDemo("Thread-2");
        R2.start();
    }
}
