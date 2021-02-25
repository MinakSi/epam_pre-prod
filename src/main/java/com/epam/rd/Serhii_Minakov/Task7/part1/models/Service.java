package com.epam.rd.Serhii_Minakov.Task7.part1.models;

import java.util.Objects;

/**
 * This class describes a service that can be ordered in a shop.
 *
 * @author Serhii_Minakov
 */
public class Service extends Goods {

    public Service() {
    }

    public Service(int id, String name, double price, String description) {
        isIdValid(id);
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Service(int id, String name, double price) {
        isIdValid(id);
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return new StringBuilder("Service{")
                .append("name='")
                .append(name)
                .append('\'')
                .append(", price=")
                .append(price)
                .append(", description='")
                .append(description)
                .append('\'')
                .append(", id=")
                .append(id)
                .append('}')
                .toString();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Service service = (Service) otherObject;
        return Double.compare(service.price, price) == 0 &&
                Objects.equals(name, service.name) &&
                Objects.equals(description, service.description);
    }
}
