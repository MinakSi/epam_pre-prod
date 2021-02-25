package com.epam.rd.Serhii_Minakov.Task7.part1;

import com.epam.rd.Serhii_Minakov.Task7.part1.models.Goods;
import com.epam.rd.Serhii_Minakov.Task7.part1.models.Product;
import com.epam.rd.Serhii_Minakov.Task7.part1.repository.GoodsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoodsSaverTest {

    @Test
    void serializeGoodsTest() throws IOException, ClassNotFoundException {
        List<Goods> goods = new ArrayList<>();
        goods.add(new Product(1, "nameProduct", 23.50, 50));
        goods.add(new Product(2, "nameProduct2", 23.50, 50));
        goods.add(new Product(3, "nameProduct3", 23.50, 50, "description3"));
        GoodsRepository repository = new GoodsRepository(goods);
        GoodsSaver.saveAll(repository);
        GoodsRepository actual = GoodsSaver.readAll();
        Assertions.assertEquals(repository.getGoods(), actual.getGoods());
    }
}
