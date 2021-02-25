package com.epam.rd.Serhii_Minakov.Task6.input.creators;

import com.epam.rd.Serhii_Minakov.Task6.input.types.GoodsInputType;
import com.epam.rd.Serhii_Minakov.Task6.models.OnlineService;

/**
 * This class creates a new instance of OnlineService based on the input type
 */
public class OnlineServiceCreator implements Creator {
    GoodsInputType inputType;

    public OnlineServiceCreator(GoodsInputType inputType) {
        this.inputType = inputType;
    }

    @Override
    public OnlineService create() {
        String name = inputType.getString();
        int id = inputType.getInt();
        double price = inputType.getDouble();
        String description = inputType.getString();
        boolean needDeviceSending = inputType.getBoolean();
        return new OnlineService(id, name, price, description, needDeviceSending);
    }
}
