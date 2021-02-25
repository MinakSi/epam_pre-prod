package com.epam.rd.Serhii_Minakov.Task9.input.creators;

import com.epam.rd.Serhii_Minakov.Task9.models.Goods;

/**
 * This interface defines a class that creates a new instance of the specified goods
 */
public interface Creator {

    Goods create();
}
