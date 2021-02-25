package com.epam.rd.Serhii_Minakov.Task7.part1.models;

import com.epam.rd.Serhii_Minakov.Task7.part1.Localization;

import java.io.Serializable;

/**
 * This class describes any physical element that can be
 * used in a shop.
 *
 * @author Serhii_Minakov
 */
public abstract class Goods implements Serializable {

    protected static final long serialVersionUID = 1L;
    @Localization(key = "id")
    protected int id;
    protected String name;
    @Localization(key = "price")
    protected double price;
    @Localization(key = "description")
    protected String description;
    private static final String EXCEPTION_MSG_NEGATIVE_ID = "id can not be negative";

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

    protected void isIdValid(int id) {
        if (id < 0) {
            throw new IllegalArgumentException(EXCEPTION_MSG_NEGATIVE_ID);
        }
    }
}


