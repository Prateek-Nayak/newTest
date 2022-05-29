// Java Program to Illustrate instanceof Keyword
package com.company;

// Importing required I/O classes
import java.io.*;

// Main class
class GFG {
    public static void main(String[] args)
    {

        // Creating object of class inside main()
        GFG object = new GFG();

        // Returning instanceof
        System.out.println(object instanceof GFG);
        if(object instanceof GFG)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
