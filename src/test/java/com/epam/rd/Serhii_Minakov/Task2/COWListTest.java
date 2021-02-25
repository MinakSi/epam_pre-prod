package com.epam.rd.Serhii_Minakov.Task2;


import com.epam.rd.Serhii_Minakov.Task1.first.Product;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class COWListTest {
    @Nested
    class AddTests {
        @Test
        void addIndexTest() {
            COWList<Product> list = new COWList<>();
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            list.add(product1);
            list.add(product2);
            list.add(1, product3);
            Product[] expected = {product1, product3, product2};
            assertArrayEquals(expected, list.toArray(new Product[0]));
        }

        @Test
        void addTest() {
            COWList<Product> list = new COWList<>();
            Product product1 = new Product(1, "a", 2, 3);
            list.add(product1);
            Product[] expected = {product1};
            assertArrayEquals(expected, list.toArray(new Product[0]));
        }
    }

    @Test
    void getTest() {
        COWList<Product> list = new COWList<>();
        Product product1 = new Product(1, "a", 2, 3);
        Product product2 = new Product(2, "a", 2, 3);
        Product product3 = new Product(3, "a", 2, 3);
        list.add(product1);
        list.add(product2);
        list.add(1, product3);
        assertEquals(product3, list.get(1));
    }

    @Nested
    class RemoveTests {
        @Test
        void removeObjectTest() {
            COWList<Product> list = new COWList<>();
            Product product1 = new Product(1, "a", 2, 3);
            list.add(product1);
            assertTrue(list.remove(product1));
        }

        @Test
        void removeSizeTest() {
            COWList<Product> list = new COWList<>();
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            list.add(product1);
            list.add(product2);
            list.add(1, product3);
            list.remove(product1);
            assertEquals(2, list.size());
        }

        @Test
        void removeIndexTest() {
            COWList<Product> list = new COWList<>();
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            list.add(product1);
            list.add(product2);
            list.add(1, product3);
            list.remove(1);
            assertEquals(list.get(1), product2);
        }
    }

    @Test
    void conditionIteratorIntegerTest() {
        COWList<Product> list = new COWList<>();
        Product product1 = new Product(1, "a", 2, 3);
        Product product2 = new Product(2, "b", 2, 3);
        Product product3 = new Product(3, "b", 2, 3);
        Product product4 = new Product(4, "a", 2, 3);
        Product product5 = new Product(5, "b", 2, 3);
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        list.add(product5);
        COWList<Product> result = new COWList<>();
        Predicate<Product> predicate = p -> p.getName().equals("b");
        Iterator<Product> iterator = list.conditionIterator(predicate);
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        Product[] expected = {product2, product3, product5};
        assertArrayEquals(expected, result.toArray());
    }

    @Test
    void COWPrincipleTest() {
        COWList<Product> list = new COWList<>();
        Product product1 = new Product(1, "a", 2, 3);
        Product product2 = new Product(2, "b", 2, 3);
        Product product3 = new Product(3, "b", 2, 3);
        Product product4 = new Product(4, "a", 2, 3);
        Product product5 = new Product(5, "b", 2, 3);
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        list.add(product5);
        COWList<Product> result = new COWList<>();
        Predicate<Product> predicate = p -> p.getName().equals("b");
        Iterator<Product> iterator = list.conditionIterator(predicate);
        boolean firstStep = true;
        while (iterator.hasNext()) {
            if(firstStep){
                list.remove(list.size()-1);
                list.remove(list.size()-1);
            }
            firstStep = false;
            result.add(iterator.next());
        }
        Product[] expected = {product2, product3, product5};
        assertArrayEquals(expected, result.toArray());
    }
}
