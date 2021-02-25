package com.epam.rd.Serhii_Minakov.Task7;

import java.io.PrintStream;

/**
 * This util class lets you to print messages
 */
public class Output {

    /**
     * Prints an object to console
     *
     * @param message - an object to be printed
     */
    public static void printMessageToConsole(Object message) {
        PrintStream printStream = new PrintStream(System.out);
        printStream.print(message);
    }

    /**
     * Prints an object to console. Adds a line separator to the end of the line.
     *
     * @param message - an object to be printed
     */
    public static void printlnMessageToConsole(Object message) {
        PrintStream printStream = new PrintStream(System.out);
        printStream.println(message);
    }
}
