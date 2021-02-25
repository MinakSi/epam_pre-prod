package com.epam.rd.Serhii_Minakov.Task6.input.types;

import java.util.Scanner;

/**
 * This class is an input type.
 * The main base of this type is console input
 */
public class ConsoleGoodsInput implements GoodsInputType {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getString() {
        System.out.println("Enter line");
        return scanner.next();
    }

    @Override
    public int getInt() {
        System.out.println("Enter int");
        return scanner.nextInt();
    }

    @Override
    public double getDouble() {
        System.out.println("Enter double");
        return scanner.nextDouble();
    }

    /**
     * This method is created to get boolean value
     * return value depends on entered data by user.
     * @return  true if entered data equals '1'
     */
    @Override
    public boolean getBoolean() {
        System.out.println("Enter boolean: 1-true / 0 - false");
        return "1".equals(scanner.next());
    }
}
