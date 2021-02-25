package com.epam.rd.Serhii_Minakov.Task6.models;

import java.io.Serializable;

/**
 * This class describes any physical element that can be
 * used in a shop.
 *
 * @author Serhii_Minakov
 */
public abstract class Goods implements Serializable {
    protected int id;
    protected String name;
    protected double price;
    protected String description;

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


