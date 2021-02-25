package com.epam.rd.Serhii_Minakov.Task7.part2.factory;

import com.epam.rd.Serhii_Minakov.Task7.models.Goods;
import com.epam.rd.Serhii_Minakov.Task7.models.IProduct;
import com.epam.rd.Serhii_Minakov.Task7.part2.proxies.ProductExceptionProxy;

import java.lang.reflect.Proxy;

public class ProductExceptionIfSetFactory implements GoodsFactory {

    @Override
    public IProduct create(Goods good) {
        IProduct product = (IProduct) good;
        ClassLoader productClassLoader = product.getClass().getClassLoader();
        Class[] interfaces = product.getClass().getInterfaces();
        return (IProduct) Proxy.newProxyInstance(productClassLoader, interfaces, new ProductExceptionProxy(product));
    }
}
