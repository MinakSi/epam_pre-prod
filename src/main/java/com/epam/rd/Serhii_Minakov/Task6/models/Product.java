package com.epam.rd.Serhii_Minakov.Task6.models;

import java.util.Objects;


/**
 * This class describes a product that can be sold in a shop.
 *
 * @author Serhii_Minakov
 */
public class Product extends Goods {
    private int amountOnStorage;

    public Product(int id, String name, double price, int amountOnStorage) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.name = name;
        this.price = price;
        this.amountOnStorage = amountOnStorage;
    }

    public Product(int id, String name, double price, int amountOnStorage, String description) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                amountOnStorage == product.amountOnStorage &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                product.id == id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amountOnStorage=" + amountOnStorage +
                ", id=" + id +
                '}';
    }
}