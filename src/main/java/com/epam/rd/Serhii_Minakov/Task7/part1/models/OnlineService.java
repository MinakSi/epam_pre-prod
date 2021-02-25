package com.epam.rd.Serhii_Minakov.Task7.part1.models;

import com.epam.rd.Serhii_Minakov.Task7.part1.Localization;

/**
 * This class describes ab online service that can be ordered in a shop.
 *
 * @author Serhii_Minakov
 */

public class OnlineService extends Service {

    private static final long serialVersionUID = 3L;
    @Localization(key = "needDeviceSending")
    private boolean needDeviceSending;

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
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        if (!super.equals(otherObject)) {
            return false;
        }
        OnlineService that = (OnlineService) otherObject;
        return needDeviceSending == that.needDeviceSending;
    }

    @Override
    public String toString() {
        return new StringBuilder("OnlineService{")
                .append("needDeviceSending=")
                .append(needDeviceSending)
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
