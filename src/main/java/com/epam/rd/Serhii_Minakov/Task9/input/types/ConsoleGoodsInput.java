package com.epam.rd.Serhii_Minakov.Task9.input.types;

import com.epam.rd.Serhii_Minakov.Task7.Output;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * This class is an input type.
 * The main base of this type is console input
 */
public class ConsoleGoodsInput implements GoodsInputType {

    private final Scanner scanner = new Scanner(System.in);
    private static final String BUNDLE_BASE_NAME = "prop";
    private static final String BUNDLE_ENTER = "enter";
    private static final String BUNDLE_TRUE = "true";
    private static final String BUNDLE_FALSE = "false";

    private ResourceBundle bundle;

    public void setLocale(Locale locale) {
        this.bundle = ResourceBundle.getBundle(BUNDLE_BASE_NAME, locale);
    }

    /**
     * Prints message to console due to localization properties.
     * Waiting for String input.
     *
     * @param key property key to get field name. if null - sets base string for String type
     * @return entered String value
     */
    @Override
    public String getString(String key) {
        Output.printlnMessageToConsole(bundle.getString(BUNDLE_ENTER) + " " + getStringFromBundle(key, BASE_STRING));
        return scanner.nextLine();
    }

    /**
     * Prints message to console due to localization properties.
     * Waiting for int input.
     *
     * @param key property key to get field name. if null - sets base string for int type
     * @return entered int value
     */
    @Override
    public int getInt(String key) {
        Output.printlnMessageToConsole(bundle.getString(BUNDLE_ENTER) + " " + getStringFromBundle(key, BASE_INT));
        int returnValue = scanner.nextInt();
        scanner.nextLine();
        return returnValue;
    }

    /**
     * Prints message to console due to localization properties.
     * Waiting for double input.
     *
     * @param key property key to get field name. if null - sets base string for double type
     * @return entered double value
     */
    @Override
    public double getDouble(String key) {
        Output.printlnMessageToConsole(bundle.getString(BUNDLE_ENTER) + " " + getStringFromBundle(key, BASE_DOUBLE));
        double returnValue = scanner.nextDouble();
        scanner.nextLine();
        return returnValue;
    }

    /**
     * Prints message to console due to localization properties.
     * This method is created to get boolean value
     * return value depends on entered data by user.
     *
     * @return true if entered data equals '1'
     */
    @Override
    public boolean getBoolean(String key) {
        Output.printlnMessageToConsole(bundle.getString(BUNDLE_ENTER) + " " + bundle.getString(key) + ": 1 - "
                + bundle.getString(BUNDLE_TRUE) + " / 0 - " + bundle.getString(BUNDLE_FALSE));
        return "1".equals(scanner.nextLine());
    }

    private String getStringFromBundle(String key, String baseValue) {
        if (key == null) {
            return baseValue;
        }
        return bundle.getString(key);
    }
}
