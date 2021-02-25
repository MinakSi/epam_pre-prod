package com.epam.rd.Serhii_Minakov.Task9.models;

import com.epam.rd.Serhii_Minakov.Task9.Localization;

import java.util.Objects;

/**
 * This class describes a departure service that can be ordered in a shop.
 *
 * @author Serhii_Minakov
 */
public class DepartureService extends Service {

    private static final long serialVersionUID = 2L;
    @Localization(key = "master")
    private String master;

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
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()){
            return false;
        }
        if (!super.equals(otherObject)){
            return false;
        }
        DepartureService that = (DepartureService) otherObject;
        return Objects.equals(master, that.master);
    }

    @Override
    public String toString() {
        return new StringBuilder("DepartureService{")
                .append("master='")
                .append(master)
                .append('\'')
                .append(", name='")
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
}
