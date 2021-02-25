package com.epam.rd.Serhii_Minakov.Task1.second;

import com.epam.rd.Serhii_Minakov.Task1.first.Product;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class MyListTest {
    @Nested
    @Tag("required")
    class AddTests {
        @Test
        void addIndexTest() {
            MyList<Product> list = new MyList<>();
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
            MyList<Product> list = new MyList<>();
            Product product1 = new Product(1, "a", 2, 3);
            list.add(product1);
            Product[] expected = {product1};
            assertArrayEquals(expected, list.toArray(new Product[0]));
        }
    }

    @Test
    void getTest() {
        MyList<Product> list = new MyList<>();
        Product product1 = new Product(1, "a", 2, 3);
        Product product2 = new Product(2, "a", 2, 3);
        Product product3 = new Product(3, "a", 2, 3);
        list.add(product1);
        list.add(product2);
        list.add(1, product3);
        assertEquals(product3, list.get(1));
    }

    @Nested
    @Tag("required")
    class RemoveTests {
        @Test
        void removeObjectTest() {
            MyList<Product> list = new MyList<>();
            Product product1 = new Product(1, "a", 2, 3);
            list.add(product1);
            assertTrue(list.remove(product1));
        }

        @Test
        void removeSizeTest() {
            MyList<Product> list = new MyList<>();
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
            MyList<Product> list = new MyList<>();
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

    @Tag("required")
    @Test
    void conditionIteratorIntegerTest() {
        MyList<Product> list = new MyList<>();
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
        MyList<Product> result = new MyList<>();
        Predicate<Product> predicate = p -> p.getName().equals("b");
        Iterator<Product> iterator = list.conditionIterator(predicate);
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        Product[] expected = {product2, product3, product5};
        assertArrayEquals(expected, result.toArray());
    }


}
