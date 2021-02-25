package com.epam.rd.Serhii_Minakov.Task6.input.types;

import java.util.Random;

/**
 * This class is an input type
 * The main base of this type is Random
 */
public class RandomGoodsInput implements GoodsInputType {
    private static final Random random = new Random();
    private static final String STRING_BASE = "Line ";
    private final static int RANDOM_INT_BOUND = 10000;
    private final static int BOOLEAN_RANDOM_BOUND = 2;

    /**
     * This method generates random string based on static string base and
     * a random number in range of random bound at the end.
     *
     * @return a string with string base at the beginning and a number at the end
     */
    @Override
    public String getString() {
        return STRING_BASE + " " + random.nextInt(RANDOM_INT_BOUND);
    }

    /**
     * Generates a random int value
     *
     * @return an int value generated randomly in range of random bound
     */
    @Override
    public int getInt() {
        return random.nextInt(RANDOM_INT_BOUND);
    }

    /**
     * @return a randomly generated double value
     */
    @Override
    public double getDouble() {
        return random.nextDouble();
    }

    /**
     * Generates a boolean value based on random generation in range of boolean random bound
     *
     * @return true if generated value equals 1
     */
    @Override
    public boolean getBoolean() {
        return random.nextInt(BOOLEAN_RANDOM_BOUND) == 1;
    }
}
