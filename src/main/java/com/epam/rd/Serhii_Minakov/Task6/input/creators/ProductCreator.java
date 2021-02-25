package com.epam.rd.Serhii_Minakov.Task6.input.creators;

import com.epam.rd.Serhii_Minakov.Task6.input.types.GoodsInputType;
import com.epam.rd.Serhii_Minakov.Task6.models.Product;

/**
 *
 * This class creates a new instance of Product based on the input type
 *
 */
public class ProductCreator implements Creator {

    GoodsInputType inputType;

    public ProductCreator(GoodsInputType inputType) {
        this.inputType = inputType;
    }

    @Override
    public Product create() {
        String name = inputType.getString();
        int id = inputType.getInt();
        double price = inputType.getDouble();
        String description = inputType.getString();
        int amountOnStorage = inputType.getInt();
        return new Product(id, name, price, amountOnStorage, description);
    }
}
