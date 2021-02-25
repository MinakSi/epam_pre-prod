package com.epam.rd.Serhii_Minakov.Task4.models;

import java.util.Objects;

/**
 * This class describes a departure service that can be ordered in a shop.
 *
 * @author Serhii_Minakov
 */
public class DepartureService extends Service {
    String master;

    public DepartureService() {
    }

    public DepartureService(int id, String name, double price, String description, String master) {
        super(id, name, price, description);
        this.master = master;
    }

    public DepartureService(int id, String name, double price, String master) {
        super(id, name, price);
        this.master = master;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DepartureService that = (DepartureService) o;
        return Objects.equals(master, that.master);
    }

    @Override
    public String toString() {
        return "DepartureService{" +
                "master='" + master + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
