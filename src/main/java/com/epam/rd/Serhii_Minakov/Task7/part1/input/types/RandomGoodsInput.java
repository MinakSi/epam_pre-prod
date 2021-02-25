package com.epam.rd.Serhii_Minakov.Task7.part1.input.types;

import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * This class is an input type
 * The main base of this type is Random
 */
public class RandomGoodsInput implements GoodsInputType {

    private static final Random random = new Random();
    private final static int RANDOM_INT_BOUND = 10000;
    private final static int BOOLEAN_RANDOM_BOUND = 2;
    private static final String BUNDLE_BASE_NAME = "prop";
    private ResourceBundle bundle;

    public void setLocale(Locale locale) {
        this.bundle = ResourceBundle.getBundle(BUNDLE_BASE_NAME, locale);
    }

    /**
     * This method generates random string based on key and
     * a random number in range of random bound at the end.
     *
     * @return a string with string base at the beginning and a number at the end
     */
    @Override
    public String getString(String key) {
        return getStringFromBundle(key, BASE_STRING) + " " + random.nextInt(RANDOM_INT_BOUND);
    }

    /**
     * Generates a random int value
     *
     * @return an int value generated randomly in range of random bound
     */
    @Override
    public int getInt(String key) {
        return random.nextInt(RANDOM_INT_BOUND);
    }

    /**
     * @return a randomly generated double value
     */
    @Override
    public double getDouble(String key) {
        return random.nextDouble();
    }

    /**
     * Generates a boolean value based on random generation in range of boolean random bound
     *
     * @return true if generated value equals 1
     */
    @Override
    public boolean getBoolean(String key) {
        return random.nextInt(BOOLEAN_RANDOM_BOUND) == 1;
    }

    private String getStringFromBundle(String key, String baseValue) {
        return Optional.ofNullable(key).isPresent() ? bundle.getString(key) : baseValue;
    }
}
