package com.epam.rd.Serhii_Minakov.Task7.part1.input.creators;

import com.epam.rd.Serhii_Minakov.Task7.part1.models.Goods;

/**
 * This interface defines a class that creates a new instance of the specified goods
 */
public interface Creator {

    Goods create();
}
