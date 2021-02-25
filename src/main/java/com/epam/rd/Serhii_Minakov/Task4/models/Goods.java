package com.epam.rd.Serhii_Minakov.Task4.models;

/**
 * This class describes any physical element that can be
 * used in a shop.
 *
 * @author Serhii_Minakov
 */
public abstract class Goods {
    protected int id;
    protected double price;

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


