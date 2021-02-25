package com.epam.rd.Serhii_Minakov.Task1.second;


import com.epam.rd.Serhii_Minakov.Task1.first.Goods;

import java.util.*;
import java.util.function.Predicate;


/**
 * This class implements List.
 * It is array based.
 * Default capacity is 10.
 * Memory is pre allocated on 50%.
 *
 * @param <E> the type of elements in this list
 * @author Serhii_Minakov
 * @see List
 */
public class MyList<E extends Goods> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MyList(int size) {
        array = new Object[size];
        this.size = 0;

    }

    public MyList() {
        this.size = 0;
        array = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, array[i])) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        a = (T[]) Arrays.copyOf(array, size, a.getClass());
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    public boolean add(E e) {
        if (size == array.length) {
            grow();
        }
        array[size] = e;
        size++;
        return true;
    }

    public boolean remove(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, array[i])) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return true;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!this.contains(o)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            this.add(element);
        }
        return true;

    }

    public boolean addAll(int index, Collection<? extends E> c) {
        int i = index;
        for (E element : c) {
            this.add(i, element);
            i++;
        }

        return true;
    }

    public boolean removeAll(Collection<?> c) {
        int startedSize = size;
        for (Object o : c) {
            boolean removed;
            do {
                removed = this.remove(o);
            } while (removed);
        }

        return startedSize != size;
    }

    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(array[i])) {
                this.remove(i);
                changed = true;
            }
        }
        return changed;
    }

    public void clear() {
        this.size = 0;
        array = new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) array[index];
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        E previous = (E) array[index];
        array[index] = element;
        return previous;
    }

    public void add(int index, E element) {
        if (size == array.length) {
            grow();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        E element = (E) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return element;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], o)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(array[i], o)) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        array = Arrays.copyOf(array, size + size / 2);
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<E> {

        private int cursor; //next item

        public IteratorImpl() {
            cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return size != cursor;
        }

        @Override
        public E next() {
            return get(cursor++);
        }
    }

    public Iterator<E> conditionIterator(Predicate<E> predicate) {
        return new ConditionIterator(predicate);
    }


    private class ConditionIterator implements Iterator<E> {

        private int cursor;
        Predicate<? super E> predicate;

        public ConditionIterator(Predicate<? super E> predicate) {
            cursor = 0;
            this.predicate = predicate;
        }

        @Override
        public boolean hasNext() {
            for (int i = cursor; i < size; i++) {
                if (predicate.test(get(i))) {
                    cursor = i;
                    return true;
                }
            }
            return false;
        }

        @Override
        public E next() {

            return get(cursor++);
        }
    }


    //stub///////////////////////////////////////////
    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
    //stub//////////////////////////////////////////
}
