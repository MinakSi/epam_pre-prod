package com.epam.rd.Serhii_Minakov.Task2;

import com.epam.rd.Serhii_Minakov.Task1.first.Product;
import com.epam.rd.Serhii_Minakov.Task1.second.MyList;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class MyListWrapperTest {
    @Nested
    class AddTests {
        @Test
        void addIndexTest() {
            MyListWrapper<Product> list = new MyListWrapper<>();
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
        void addIndexIntoUnmodifiableTest() {
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            MyList<Product> unmodifiable = new MyList<>();
            unmodifiable.add(product1);
            unmodifiable.add(product2);
            unmodifiable.add(product3);
            MyListWrapper<Product> list = new MyListWrapper<>(unmodifiable);
            list.add(product1);
            list.add(product2);
            assertThrows(IllegalArgumentException.class, ()->list.add(1, product3));
        }

        @Test
        void addTest() {
            MyListWrapper<Product> list = new MyListWrapper<>();
            Product product1 = new Product(1, "a", 2, 3);
            list.add(product1);
            Product[] expected = {product1};
            assertArrayEquals(expected, list.toArray(new Product[0]));
        }

        @Test
        void addAllTest() {
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            MyList<Product> unmodifiable = new MyList<>();
            unmodifiable.add(product1);
            unmodifiable.add(product2);
            unmodifiable.add(product3);
            MyListWrapper<Product> list = new MyListWrapper<>(unmodifiable);
            assertThrows(IndexOutOfBoundsException.class, ()->list.addAll(20, unmodifiable));
        }
    }

    @Test
    void getTest() {
        MyListWrapper<Product> list = new MyListWrapper<>();
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
            MyListWrapper<Product> list = new MyListWrapper<>();
            Product product1 = new Product(1, "a", 2, 3);
            list.add(product1);
            assertTrue(list.remove(product1));
        }

        @Test
        void removeObjectFromUnmodifiable() {
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            MyList<Product> unmodifiable = new MyList<>();
            unmodifiable.add(product1);
            unmodifiable.add(product2);
            unmodifiable.add(product3);
            MyListWrapper<Product> list = new MyListWrapper<>(unmodifiable);
            list.add(product1);
            assertThrows(IllegalArgumentException.class, ()->list.remove(product1));
        }

        @Test
        void removeSizeTest() {
            MyListWrapper<Product> list = new MyListWrapper<>();
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
            MyListWrapper<Product> list = new MyListWrapper<>();
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            list.add(product1);
            list.add(product2);
            list.add(1, product3);
            list.remove(1);
            assertEquals(list.get(1), product2);
        }

        @Test
        void removeIndexFromUnmodifiable() {
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            MyList<Product> unmodifiable = new MyList<>();
            unmodifiable.add(product1);
            unmodifiable.add(product2);
            unmodifiable.add(product3);
            MyListWrapper<Product> list = new MyListWrapper<>(unmodifiable);
            list.add(product1);
            assertThrows(IllegalArgumentException.class, ()->list.remove(1));
        }
    }
    @Nested
    class IteratorTests{
        @Test
        void iteratorTest() {
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            MyList<Product> unmodifiable = new MyList<>();
            unmodifiable.add(product1);
            unmodifiable.add(product2);
            unmodifiable.add(product3);
            MyListWrapper<Product> list = new MyListWrapper<>(unmodifiable);
            list.add(product1);
            Object[] expected = {product1, product2, product3, product1};
            Object[] actual = new Object[4];
            int i =-1;
            for (Object o: list){
                actual[++i] = o;
            }
            assertArrayEquals(expected, actual);
        }

        @Test
        void iteratorRemoveTest() {
            Product product1 = new Product(1, "a", 2, 3);
            Product product2 = new Product(2, "a", 2, 3);
            Product product3 = new Product(3, "a", 2, 3);
            MyList<Product> unmodifiable = new MyList<>();
            unmodifiable.add(product1);
            unmodifiable.add(product2);
            unmodifiable.add(product3);
            MyListWrapper<Product> list = new MyListWrapper<>(unmodifiable);
            Product product4 = new Product(4, "a", 2, 3);
            Product product5 = new Product(4, "a", 2, 3);
            list.add(product4);
            list.add(product5);
            Object[] expected = {product1, product2, product3};
            Iterator<Product> iterator = list.iterator();
            int i =-1;
            while (iterator.hasNext()){
                i++;
                if (i==3||i==4){
                    iterator.remove();
                } else {
                    iterator.next();
                }
            }
            Object[] actual = list.toArray(new Product[0]);
            assertArrayEquals(expected, actual);
        }
    }
}
