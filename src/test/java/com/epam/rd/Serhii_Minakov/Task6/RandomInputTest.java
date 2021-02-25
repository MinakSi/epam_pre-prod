package com.epam.rd.Serhii_Minakov.Task6;

import com.epam.rd.Serhii_Minakov.Task6.input.types.RandomGoodsInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomInputTest {
    @Test
    void booleanTest() {
        RandomGoodsInput randomGoodsInput = new RandomGoodsInput();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(randomGoodsInput.getInt());
        }
        Assertions.assertFalse(list.contains(2));
    }
}
