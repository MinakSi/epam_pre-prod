package com.epam.rd.Serhii_Minakov.Task6.input.creators;

import com.epam.rd.Serhii_Minakov.Task6.models.Goods;

/**
 * This interface defines a class that creates a new instance of the specified goods
 */
public interface Creator {
    Goods create();
}
