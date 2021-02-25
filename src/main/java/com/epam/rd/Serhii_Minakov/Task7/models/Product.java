package com.epam.rd.Serhii_Minakov.Task7.models;


/**
 * This class describes a product that can be sold in a shop.
 *
 * @author Serhii_Minakov
 */
public class Product extends Goods implements IProduct {

    private int amountOnStorage;
    private static final long serialVersionUID = 2L;
    private static final String EXCEPTION_MSG_NEGATIVE_ID = "id can not be negative";

    public Product(int id, String name, double price, int amountOnStorage) {
        isIdValid(id);
        this.id = id;
        this.name = name;
        this.price = price;
        this.amountOnStorage = amountOnStorage;
    }

    public Product(int id, String name, double price, int amountOnStorage, String description) {
        isIdValid(id);
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountOnStorage = amountOnStorage;
    }

    private void isIdValid(int id) {
        if (id < 0) {
            throw new IllegalArgumentException(EXCEPTION_MSG_NEGATIVE_ID);
        }
    }

    public int getAmountOnStorage() {
        return amountOnStorage;
    }

    public void setAmountOnStorage(int amountOnStorage) {
        this.amountOnStorage = amountOnStorage;
    }

    @Override
    public String toString() {
        return new StringBuilder("Product{")
                .append("name='")
                .append(name)
                .append('\'')
                .append(", description='")
                .append(description)
                .append('\'')
                .append(", price=")
                .append(price)
                .append(", amountOnStorage=")
                .append(amountOnStorage)
                .append(", id=")
                .append(id)
                .append('}')
                .toString();
    }
}