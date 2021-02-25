package com.epam.rd.Serhii_Minakov.Task9.input.creators;

import com.epam.rd.Serhii_Minakov.Task9.input.AnnotationHelper;
import com.epam.rd.Serhii_Minakov.Task9.input.types.GoodsInputType;
import com.epam.rd.Serhii_Minakov.Task9.models.Product;

/**
 * This class creates a new instance of Product based on the input type
 */
public class ProductCreator implements Creator {

    private final GoodsInputType inputType;
    private final GoodsFieldCreator goodsFieldCreator;
    private final AnnotationHelper helper;
    private static final String FIELD_NAME_AMOUNT_ON_STORAGE = "amountOnStorage";

    public ProductCreator(GoodsInputType inputType) {
        this.inputType = inputType;
        this.helper = new AnnotationHelper(Product.class);
        this.goodsFieldCreator = new GoodsFieldCreator(inputType, helper);
    }

    @Override
    public Product create() {
        String name = goodsFieldCreator.createName();
        int id = goodsFieldCreator.createId();
        double price = goodsFieldCreator.createPrice();
        String description = goodsFieldCreator.createDescription();
        int amountOnStorage = inputType.getInt(helper.getKeyFromAnnotation(FIELD_NAME_AMOUNT_ON_STORAGE));
        return new Product(id, name, price, amountOnStorage, description);
    }
}
