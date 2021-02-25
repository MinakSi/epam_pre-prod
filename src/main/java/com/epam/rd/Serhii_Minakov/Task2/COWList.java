package com.epam.rd.Serhii_Minakov.Task2;


import com.epam.rd.Serhii_Minakov.Task1.first.Goods;

import java.util.*;
import java.util.function.Predicate;

/**
 * This class implements List.
 * It is array based.
 * Default capacity is 10.
 * Memory is pre allocated on 50%.
 * Realized COW strategy.
 * Realized agile iterator based on Predicate.
 *
 * @param <E> the type of elements in this list
 * @author Serhii_Minakov
 * @see List
 */
public class COWList<E extends Goods> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public COWList(int size) {
        array = new Object[size];
        this.size = 0;

    }

    public COWList() {
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
        Object[] arrCopy = array.clone();
        arrCopy[size] = e;
        size++;
        array = arrCopy;
        return true;
    }

    public boolean remove(Object o) {
        Object[] arrCopy = array.clone();
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, arrCopy[i])) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        System.arraycopy(arrCopy, index + 1, arrCopy, index, size - index - 1);
        size--;
        array = arrCopy;
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
        Object[] arrCopy = array.clone();
        E previous = (E) arrCopy[index];
        arrCopy[index] = element;
        array = arrCopy;
        return previous;
    }

    public void add(int index, E element) {
        if (size == array.length) {
            grow();
        }
        Object[] arrCopy = array.clone();
        int sizeCopy = size;
        System.arraycopy(arrCopy, index, arrCopy, index + 1, sizeCopy - index);
        arrCopy[index] = element;
        sizeCopy++;
        size = sizeCopy;
        array = arrCopy;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        E element = (E) array[index];
        Object[] arrCopy = array.clone();
        int sizeCopy = size;
        System.arraycopy(arrCopy, index + 1, arrCopy, index, sizeCopy - index - 1);
        sizeCopy--;
        size=sizeCopy;
        array = arrCopy.clone();
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
        private final Object[] arrCopy;
        private final int sizeCopy;


        public IteratorImpl() {
            arrCopy = array;
            cursor = 0;
            sizeCopy = size;
        }

        @Override
        public boolean hasNext() {
            return sizeCopy != cursor;
        }

        @Override
        public E next() {
            return (E)arrCopy[cursor++];
        }

        @Override
        public void remove() {
            System.arraycopy(arrCopy, cursor + 1, arrCopy, cursor, sizeCopy - cursor - 1);
        }
    }

    public Iterator<E> conditionIterator(Predicate<E> predicate) {
        return new ConditionIterator(predicate);
    }

    /**
     * ConditionIterator is an agile iterator based on Predicate.
     * Returns only the objects which satisfy the condition.
     * Condition sets via constructor as a Predicate.
     */
    private class ConditionIterator implements Iterator<E> {

        private int cursor;
        Predicate<? super E> predicate;
        private final Object[] arrCopy;
        private final int sizeCopy;

        public ConditionIterator(Predicate<? super E> predicate) {
            arrCopy = array;
            cursor = 0;
            sizeCopy = size;
            this.predicate = predicate;
        }

        @Override
        public boolean hasNext() {
            for (int i = cursor; i < sizeCopy; i++) {
                if (predicate.test(get(i))) {
                    cursor = i;
                    return true;
                }
            }
            return false;
        }

        @Override
        public E next() {
            return (E)arrCopy[cursor++];
        }
        @Override
        public void remove() {
            System.arraycopy(arrCopy, cursor + 1, arrCopy, cursor, sizeCopy - cursor - 1);
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
