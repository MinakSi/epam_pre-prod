package com.epam.rd.Serhii_Minakov.Task9.input.creators;

import com.epam.rd.Serhii_Minakov.Task9.input.AnnotationHelper;
import com.epam.rd.Serhii_Minakov.Task9.input.types.GoodsInputType;
import com.epam.rd.Serhii_Minakov.Task9.models.DepartureService;

/**
 * This class creates a new instance of DepartureService based on the input type
 */
public class DepartureServiceCreator implements Creator {

    private final GoodsInputType inputType;
    private final GoodsFieldCreator goodsFieldCreator;
    private final AnnotationHelper helper;
    private static final String FIELD_NAME_MASTER = "master";

    public DepartureServiceCreator(GoodsInputType inputType) {
        this.inputType = inputType;
        this.helper = new AnnotationHelper(DepartureService.class);
        this.goodsFieldCreator = new GoodsFieldCreator(inputType, helper);
    }

    @Override
    public DepartureService create() {
        String name = goodsFieldCreator.createName();
        int id = goodsFieldCreator.createId();
        double price = goodsFieldCreator.createPrice();
        String description = goodsFieldCreator.createDescription();
        String master = inputType.getString(helper.getKeyFromAnnotation(FIELD_NAME_MASTER));
        return new DepartureService(id, name, price, description, master);
    }
}
