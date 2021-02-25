package com.epam.rd.Serhii_Minakov.Task7;

import com.epam.rd.Serhii_Minakov.Task7.part2.factory.GoodsFactory;
import com.epam.rd.Serhii_Minakov.Task7.part2.factory.ProductExceptionIfSetFactory;
import com.epam.rd.Serhii_Minakov.Task7.models.IProduct;
import com.epam.rd.Serhii_Minakov.Task7.models.Product;

public class Demo {

    public static void main(String[] args) {
        GoodsFactory factory = new ProductExceptionIfSetFactory();
        IProduct product = factory.create(new Product(1, "name", 2, 5));
        System.out.println(product);
        System.out.println(product.getDescription());
    }
}
