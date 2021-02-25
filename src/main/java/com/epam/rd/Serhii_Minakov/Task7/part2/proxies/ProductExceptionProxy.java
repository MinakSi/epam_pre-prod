package com.epam.rd.Serhii_Minakov.Task7.part2.proxies;

import com.epam.rd.Serhii_Minakov.Task7.models.IProduct;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProductExceptionProxy implements InvocationHandler {

    private final IProduct product;
    private static final String SETTER_REGEX = "^set.+$";

    public ProductExceptionProxy(IProduct product) {
        this.product = product;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().matches(SETTER_REGEX)) {
            throw new UnsupportedOperationException("Set methods are unsupported");
        }
        return method.invoke(product, args);
    }
}
