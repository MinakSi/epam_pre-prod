package com.epam.rd.Serhii_Minakov.Task7.part1.input.creators;

import com.epam.rd.Serhii_Minakov.Task7.part1.input.AnnotationHelper;
import com.epam.rd.Serhii_Minakov.Task7.part1.input.types.GoodsInputType;
import com.epam.rd.Serhii_Minakov.Task7.part1.models.OnlineService;

/**
 * This class creates a new instance of OnlineService based on the input type
 */
public class OnlineServiceCreator implements Creator {

    private final GoodsInputType inputType;
    private final GoodsFieldCreator goodsFieldCreator;
    private final AnnotationHelper helper;
    private static final String FIELD_NAME_NEED_DEVICE_SENDING = "needDeviceSending";

    public OnlineServiceCreator(GoodsInputType inputType) {
        this.inputType = inputType;
        this.helper = new AnnotationHelper(OnlineService.class);
        this.goodsFieldCreator = new GoodsFieldCreator(inputType, helper);
    }

    @Override
    public OnlineService create() {
        String name = goodsFieldCreator.createName();
        int id = goodsFieldCreator.createId();
        double price = goodsFieldCreator.createPrice();
        String description = goodsFieldCreator.createDescription();
        boolean needDeviceSending = inputType.getBoolean(helper.getKeyFromAnnotation(FIELD_NAME_NEED_DEVICE_SENDING));
        return new OnlineService(id, name, price, description, needDeviceSending);
    }
}
