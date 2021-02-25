package com.epam.rd.Serhii_Minakov.Task7.part3.proxies;

import com.epam.rd.Serhii_Minakov.Task7.models.IProduct;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;

public class ProductMapProxy implements InvocationHandler {

    private final Map<String, Object> map;
    private final IProduct product;

    private static final String SETTER_REGEX = "^set.+$";
    private static final String GETTER_REGEX = "^get.+$";
    private static final String FIELD_NAME_REGEX = "(^set)|(^get)";

    public ProductMapProxy(Map<String, Object> map, IProduct product) {
        this.map = map;
        this.product = product;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if (methodName.matches(SETTER_REGEX)) {
            String key = methodName.replaceAll(FIELD_NAME_REGEX, "").toLowerCase(Locale.ROOT);
            map.put(key, args[0]);
        } else if (methodName.matches(GETTER_REGEX)) {
            String key = methodName.replaceAll(FIELD_NAME_REGEX, "").toLowerCase(Locale.ROOT);
            return map.get(key);
        }
        return method.invoke(product, args);
    }
}
