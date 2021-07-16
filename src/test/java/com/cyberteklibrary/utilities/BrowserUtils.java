package com.cyberteklibrary.utilities;

public class BrowserUtils {
    //copy whatever you have from urdaas
 /*
    Method that will accept int
    Wait for given second duration
     */
    public static void sleep(int second) {
        second *= 1000;
        try {

            Thread.sleep(second);

        } catch (InterruptedException e) {

            System.out.println("something happened in the sleep method");
        }
    }
}
