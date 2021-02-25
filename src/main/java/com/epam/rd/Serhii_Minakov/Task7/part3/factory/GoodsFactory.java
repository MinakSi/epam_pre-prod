package com.epam.rd.Serhii_Minakov.Task7.part3.factory;

import com.epam.rd.Serhii_Minakov.Task7.models.Goods;
import com.epam.rd.Serhii_Minakov.Task7.models.IProduct;

import java.util.Map;

public interface GoodsFactory {

    IProduct create(Goods good, Map<String, Object> map);
}
