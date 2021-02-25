package com.epam.rd.Serhii_Minakov.Task3.StringWrapper;

/**
 * This class wraps String and overrides the hashCode method
 */
public class StringWrapperLength extends StringWrapper {

    public StringWrapperLength(String body) {
        this.body = body;
    }

    /**
     * Hash is the length of the body element
     *
     * @return hash of body element
     */
    @Override
    public int hashCode() {
        return getBody().length();
    }
}
