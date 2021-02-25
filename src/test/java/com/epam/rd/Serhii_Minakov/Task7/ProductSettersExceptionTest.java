package com.epam.rd.Serhii_Minakov.Task7;

import com.epam.rd.Serhii_Minakov.Task7.part2.factory.GoodsFactory;
import com.epam.rd.Serhii_Minakov.Task7.part2.factory.ProductExceptionIfSetFactory;
import com.epam.rd.Serhii_Minakov.Task7.models.IProduct;
import com.epam.rd.Serhii_Minakov.Task7.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductSettersExceptionTest {

    private final GoodsFactory factory = new ProductExceptionIfSetFactory();
    private IProduct product = factory.create(new Product(1, "name", 2, 5));

    @Test
    void setNameTest() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> product.setName("name"));
    }

    @Test
    void setPriceTest() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> product.setPrice(99));
    }

    @Test
    void setDescriptionTest() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> product.setDescription("description"));
    }

    @Test
    void setAmountOnStorageTest() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> product.setAmountOnStorage(99));
    }

    @Test
    void getIdTest() {
        Assertions.assertEquals(1, product.getId());
    }
}
