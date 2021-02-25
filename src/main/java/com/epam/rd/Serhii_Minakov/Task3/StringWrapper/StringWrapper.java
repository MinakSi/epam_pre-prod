package com.epam.rd.Serhii_Minakov.Task3.StringWrapper;

import java.util.Objects;

/**
 * This class realizes a String wrapper for equals or hashCode methods modification
 */

public abstract class StringWrapper {

    String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringWrapper that = (StringWrapper) o;
        return Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }
}
