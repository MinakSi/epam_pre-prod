package com.epam.rd.Serhii_Minakov.Task4.models;

/**
 * This class describes ab online service that can be ordered in a shop.
 *
 * @author Serhii_Minakov
 */

public class OnlineService extends Service {
    boolean needDeviceSending;

    public OnlineService() {
    }

    public OnlineService(int id, String name, double price, String description, boolean needDeviceSending) {
        super(id, name, price, description);
        this.needDeviceSending = needDeviceSending;
    }

    public OnlineService(int id, String name, double price, boolean needDeviceSending) {
        super(id, name, price);
        this.needDeviceSending = needDeviceSending;
    }

    public boolean isNeedDeviceSending() {
        return needDeviceSending;
    }

    public void setNeedDeviceSending(boolean needDeviceSending) {
        this.needDeviceSending = needDeviceSending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OnlineService that = (OnlineService) o;
        return needDeviceSending == that.needDeviceSending;
    }

    @Override
    public String toString() {
        return "OnlineService{" +
                "needDeviceSending=" + needDeviceSending +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
