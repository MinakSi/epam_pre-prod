package com.epam.rd.Serhii_Minakov.Task9.models;

import com.epam.rd.Serhii_Minakov.Task9.Localization;

import java.util.Objects;


/**
 * This class describes a product that can be sold in a shop.
 *
 * @author Serhii_Minakov
 */
public class Product extends Goods {

    private static final long serialVersionUID = 4L;
    @Localization(key = "amountOnStorage")
    private int amountOnStorage;

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

    public int getAmountOnStorage() {
        return amountOnStorage;
    }

    public void setAmountOnStorage(int amountOnStorage) {
        this.amountOnStorage = amountOnStorage;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Product product = (Product) otherObject;
        return Double.compare(product.price, price) == 0 &&
                amountOnStorage == product.amountOnStorage &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                product.id == id;
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
