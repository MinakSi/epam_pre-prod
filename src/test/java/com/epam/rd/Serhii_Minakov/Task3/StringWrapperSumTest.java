package com.epam.rd.Serhii_Minakov.Task3;

import com.epam.rd.Serhii_Minakov.Task3.StringWrapper.StringWrapperSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringWrapperSumTest {
    @Test
    void hashTest() {
        StringWrapperSum four = new StringWrapperSum("aaaa");
        StringWrapperSum three = new StringWrapperSum("aaa");
        assertTrue(four.hashCode() > three.hashCode());
    }
}
