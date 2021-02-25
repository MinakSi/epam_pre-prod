package com.epam.rd.Serhii_Minakov.Task9.input.creators;

import com.epam.rd.Serhii_Minakov.Task9.input.AnnotationHelper;
import com.epam.rd.Serhii_Minakov.Task9.input.types.GoodsInputType;

/**
 * This util class creates base fields described in the Goods model
 */
public class GoodsFieldCreator {

    private final GoodsInputType inputType;
    private final AnnotationHelper helper;
    private static final String FIELD_NAME_NAME = "name";
    private static final String FIELD_NAME_ID = "id";
    private static final String FIELD_NAME_PRICE = "price";
    private static final String FIELD_NAME_DESCRIPTION = "description";

    public GoodsFieldCreator(GoodsInputType inputType, AnnotationHelper helper) {
        this.inputType = inputType;
        this.helper = helper;
    }

    public int createId() {
        return inputType.getInt(helper.getKeyFromAnnotation(FIELD_NAME_ID));
    }

    public String createName() {
        return inputType.getString(helper.getKeyFromAnnotation(FIELD_NAME_NAME));
    }

    public double createPrice() {
        return inputType.getDouble(helper.getKeyFromAnnotation(FIELD_NAME_PRICE));
    }

    public String createDescription() {
        return inputType.getString(helper.getKeyFromAnnotation(FIELD_NAME_DESCRIPTION));
    }
}
