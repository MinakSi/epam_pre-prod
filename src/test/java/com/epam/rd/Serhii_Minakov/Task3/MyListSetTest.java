package com.epam.rd.Serhii_Minakov.Task3;

import com.epam.rd.Serhii_Minakov.Task1.first.Product;
import com.epam.rd.Serhii_Minakov.Task1.second.MyList;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class MyListSetTest {
    @Nested
    class AddTests {
        @Test
        void addTest() {
            MyListSet<Product> listSet = new MyListSet<>();
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            listSet.add(product1);
            listSet.add(product3);
            listSet.add(product2);
            Product[] expected = {product1, product3, product2};
            assertArrayEquals(expected, listSet.toArray(new Product[0]));
        }

        @Test
        void addSameTest() {
            MyListSet<Product> listSet = new MyListSet<>();
            Product product1 = new Product(1, "a", 2, 3);
            listSet.add(product1);
            assertThrows(IllegalArgumentException.class, () -> listSet.add(product1));
        }

        @Test
        void addIndexTest() {
            MyListSet<Product> listSet = new MyListSet<>();
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            listSet.add(product1);
            listSet.add(product2);
            listSet.add(1, product3);
            Product[] expected = {product1, product3, product2};
            assertArrayEquals(expected, listSet.toArray(new Product[0]));
        }

        @Test
        void addIndexSameTest() {
            MyListSet<Product> listSet = new MyListSet<>();
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            listSet.add(product3);
            listSet.add(product2);
            assertThrows(IllegalArgumentException.class, () -> listSet.add(1, product3));
        }

        @Test
        void addAllTest() {
            MyListSet<Product> listSet = new MyListSet<>();
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            MyList<Product> list = new MyList<>();
            list.add(product1);
            list.add(product2);
            list.add(1, product3);
            listSet.addAll(list);
            Product[] expected = {product1, product3, product2};
            assertArrayEquals(expected, listSet.toArray(new Product[0]));
        }

        @Test
        void addAllSameTest() {
            MyListSet<Product> listSet = new MyListSet<>();
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            listSet.add(product2);
            MyList<Product> list = new MyList<>();
            list.add(product1);
            list.add(product2);
            list.add(1, product3);
            assertThrows(IllegalArgumentException.class, () -> listSet.addAll(list));
        }
    }
}
