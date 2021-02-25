package com.epam.rd.Serhii_Minakov.Task7.part2.factory;

import com.epam.rd.Serhii_Minakov.Task7.models.Goods;
import com.epam.rd.Serhii_Minakov.Task7.models.IProduct;

public interface GoodsFactory {

    IProduct create(Goods good);
}
