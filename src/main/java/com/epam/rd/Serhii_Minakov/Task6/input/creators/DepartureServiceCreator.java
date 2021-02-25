package com.epam.rd.Serhii_Minakov.Task6.input.creators;

import com.epam.rd.Serhii_Minakov.Task6.input.types.GoodsInputType;
import com.epam.rd.Serhii_Minakov.Task6.models.DepartureService;

/**
 * This class creates a new instance of DepartureService based on the input type
 */
public class DepartureServiceCreator implements Creator {
    GoodsInputType inputType;

    public DepartureServiceCreator(GoodsInputType inputType) {
        this.inputType = inputType;
    }

    @Override
    public DepartureService create() {
        String name = inputType.getString();
        int id = inputType.getInt();
        double price = inputType.getDouble();
        String description = inputType.getString();
        String master = inputType.getString();
        return new DepartureService(id, name, price, description, master);
    }
}
