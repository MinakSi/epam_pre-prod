package com.epam.rd.Serhii_Minakov.Task7;

import com.epam.rd.Serhii_Minakov.Task7.models.IProduct;
import com.epam.rd.Serhii_Minakov.Task7.models.Product;
import com.epam.rd.Serhii_Minakov.Task7.part3.factory.GoodsFactory;
import com.epam.rd.Serhii_Minakov.Task7.part3.factory.ProductMapFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ProductMapTest {

    private final GoodsFactory factory = new ProductMapFactory();
    private final Map<String, Object> map = new HashMap<>();
    private IProduct product = factory.create(new Product(1, "name", 2, 5), map);

    @Test
    void getFromMapViaMethodTest() {
        product.setPrice(50);
        Assertions.assertEquals(50.0, map.get("price"));
    }

    @Test
    void setMethodTest() {
        product.setPrice(50);
        Assertions.assertEquals(50.0, product.getPrice());
    }
}
