package com.epam.rd.Serhii_Minakov.Task4.models;

import java.util.Objects;

/**
 * This class describes a service that can be ordered in a shop.
 *
 * @author Serhii_Minakov
 */
public class Service extends Goods {
    protected String name;
//    protected double price;
    protected String description;

    public Service() {
    }

    public Service(int id, String name, double price, String description) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;

    }

    public Service(int id, String name, double price) {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Double.compare(service.price, price) == 0 &&
                Objects.equals(name, service.name) &&
                Objects.equals(description, service.description);
    }


}
