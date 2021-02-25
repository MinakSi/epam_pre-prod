package com.epam.rd.Serhii_Minakov.Task7.part3.factory;

import com.epam.rd.Serhii_Minakov.Task7.models.Goods;
import com.epam.rd.Serhii_Minakov.Task7.models.IProduct;
import com.epam.rd.Serhii_Minakov.Task7.part3.proxies.ProductMapProxy;

import java.lang.reflect.Proxy;
import java.util.Map;

public class ProductMapFactory implements GoodsFactory {

    @Override
    public IProduct create(Goods good, Map<String, Object> map) {
        IProduct product = (IProduct) good;
        ClassLoader productClassLoader = product.getClass().getClassLoader();
        Class[] interfaces = product.getClass().getInterfaces();
        return (IProduct) Proxy.newProxyInstance(productClassLoader, interfaces, new ProductMapProxy(map, product));
    }
}
