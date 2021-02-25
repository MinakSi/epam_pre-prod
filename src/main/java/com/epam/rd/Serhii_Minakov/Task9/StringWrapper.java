package com.epam.rd.Serhii_Minakov.Task9;

import java.util.Objects;

/**
 * This class realizes a String wrapper for equals or hashCode methods modification
 */

public class StringWrapper {

    private String body;

    public StringWrapper() {
    }

    public StringWrapper(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        StringWrapper that = (StringWrapper) otherObject;
        return Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public String toString() {
        return getBody();
    }
}
