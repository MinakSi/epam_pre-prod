package com.epam.rd.Serhii_Minakov.Task3.StringWrapper;

/**
 * This class wraps String and overrides the hashCode method
 */
public class StringWrapperSum extends StringWrapper {
    public StringWrapperSum(String body) {
        this.body = body;
    }

    /**
     * Hash is the sum of the first four chars of the body element
     *
     * @return hash of body element
     */
    @Override
    public int hashCode() {
        int sum = 0;
        if (body.length() < 4) {
            for (char ch : getBody().toCharArray()) {
                sum += ch;
            }
            return sum;
        }
        char[] arr = new char[4];
        getBody().getChars(0, 4, arr, 0);
        for (char ch : arr) {
            sum += ch;
        }
        return sum;
    }
}
