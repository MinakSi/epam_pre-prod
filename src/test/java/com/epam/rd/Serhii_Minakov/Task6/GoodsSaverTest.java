package com.epam.rd.Serhii_Minakov.Task6;

import com.epam.rd.Serhii_Minakov.Task6.models.Goods;
import com.epam.rd.Serhii_Minakov.Task6.models.Product;
import com.epam.rd.Serhii_Minakov.Task6.repository.GoodsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GoodsSaverTest {
    @Test
    void serializationDeserializationEqualityTest() throws IOException, ClassNotFoundException {
        GoodsRepository expected = new GoodsRepository();
        expected.add(new Product(1, "22", 2, 3, "lol"));
        GoodsRepository actual;
        GoodsSaver.saveAll(expected);
        actual = GoodsSaver.readAll();
        Assertions.assertArrayEquals(expected.getGoods().toArray(new Goods[0]), actual.getGoods().toArray(new Goods[0]));
    }
}
