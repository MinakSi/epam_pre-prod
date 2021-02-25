package com.epam.rd.Serhii_Minakov.Task3;

import com.epam.rd.Serhii_Minakov.Task1.first.Product;
import com.epam.rd.Serhii_Minakov.Task3.StringWrapper.StringWrapperLength;
import com.epam.rd.Serhii_Minakov.Task3.StringWrapper.StringWrapperSum;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Demo {
    public static void main(String[] args) {
        System.out.println("-----------Length------------");
        stringWrapperDemoLength();
        System.out.println("-----------SUM------------");
        stringWrapperDemoSum();
        /*
         * index: hash & (length-1)
         * */


    }

    private static void stringWrapperDemoLength() {
        HashMap<StringWrapperLength, Product> map = new HashMap<>();
        Product product1 = new Product(1, "Monkey", 220, 30);
        Product product2 = new Product(2, "Ted", 210, 45);
        Product product3 = new Product(3, "Heart", 139, 3);
        StringWrapperLength stringWrapper1 = new StringWrapperLength("Monkey");
        StringWrapperLength stringWrapper2 = new StringWrapperLength("Ted");
        StringWrapperLength stringWrapper3 = new StringWrapperLength("Heart");
        map.put(stringWrapper1, product1);
        map.put(stringWrapper2, product2);
        map.put(stringWrapper3, product3);
        System.out.println("Hash Map:");
        for (HashMap.Entry<StringWrapperLength, Product> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("\nLinked Hash Map:");
        LinkedHashMap<StringWrapperLength, Product> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(new StringWrapperLength("Monkey"), product1);
        linkedHashMap.put(new StringWrapperLength("Ted"), product2);
        linkedHashMap.put(new StringWrapperLength("Heart"), product3);
        for (HashMap.Entry<StringWrapperLength, Product> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

    private static void stringWrapperDemoSum() {
        HashMap<StringWrapperSum, Product> map = new HashMap<>();
        Product product1 = new Product(1, "Monkey", 220, 30);
        Product product2 = new Product(2, "Ted", 210, 45);
        Product product3 = new Product(3, "Heart", 139, 3);
        StringWrapperSum stringWrapper1 = new StringWrapperSum("Monkey");
        StringWrapperSum stringWrapper2 = new StringWrapperSum("Ted");
        StringWrapperSum stringWrapper3 = new StringWrapperSum("Heart");
        map.put(stringWrapper3, product3);
        map.put(stringWrapper1, product1);
        map.put(stringWrapper2, product2);
        System.out.println("Hash Map:");
        for (HashMap.Entry<StringWrapperSum, Product> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("\nLinked Hash Map:");
        LinkedHashMap<StringWrapperSum, Product> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(new StringWrapperSum("Heart"), product3);
        linkedHashMap.put(new StringWrapperSum("Monkey"), product1);
        linkedHashMap.put(new StringWrapperSum("Ted"), product2);
        for (HashMap.Entry<StringWrapperSum, Product> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }


}
