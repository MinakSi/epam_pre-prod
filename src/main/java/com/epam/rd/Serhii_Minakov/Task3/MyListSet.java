package com.epam.rd.Serhii_Minakov.Task3;

import com.epam.rd.Serhii_Minakov.Task1.first.Goods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

/**
 * This List is based on ArrayList and realizes all the functionality of it.
 * This List provides setting and containing unique elements.
 *
 * @param <E> the type of elements in this list
 */
public class MyListSet<E extends Goods> extends ArrayList<E> {

    public static final String ELEMENT_ALREADY_EXISTS_EXCEPTION = "this element already exists";
    public static final String DUPLICATE_COLLECTION_ELEMENTS = "input collection has duplicate elements";

    public MyListSet(int initialCapacity) {
        super(initialCapacity);
    }

    public MyListSet() {
        super();
    }

    /**
     * Checks if element is already in the List. If it is - throws an exception, else
     * goes to method set of ArrayList.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the position
     * @throws IllegalArgumentException if the element already exists in the list
     */
    @Override
    public E set(int index, E element) {
        throwIfContains(element);
        return super.set(index, element);
    }

    /**
     * Checks if element is already in the List. If it is - throws an exception, else
     * goes to method add of ArrayList.
     *
     * @param e element to be stored
     * @return true if succeed
     * @throws IllegalArgumentException if the element already exists in the list
     */
    @Override
    public boolean add(E e) {
        throwIfContains(e);
        return super.add(e);
    }

    /**
     * Checks if element is already in the List. If it is - throws an exception, else
     * goes to method add of ArrayList.
     *
     * @param element element to be stored
     * @param index   position to be stored on
     * @return true if succeed
     * @throws IllegalArgumentException if the element already exists in the list
     */
    @Override
    public void add(int index, E element) {
        throwIfContains(element);
        super.add(index, element);
    }

    /**
     * Checks if collection consists if unique elements.
     * Checks if there are duplicates after merge.
     * Goes to method addAll of ArrayList.
     *
     * @param c - collection to be stored
     * @return true if succeed
     * @throws IllegalArgumentException if collection has duplicates or
     *                                  if any element from this collection is already in this List
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        collectionDuplicateCheck(c);
        for (Object o : c) {
            throwIfContains(o);
        }
        return super.addAll(c);
    }


    /**
     * Checks if collection consists if unique elements.
     * Checks if there are duplicates after merge.
     * Goes to method addAll of ArrayList.
     *
     * @param c     - collection to be stored
     * @param index - position to be stored on
     * @return true if succeed
     * @throws IllegalArgumentException if collection has duplicates or
     *                                  if any element from this collection is already in this List
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        collectionDuplicateCheck(c);
        for (Object o : c) {
            throwIfContains(o);
        }
        return super.addAll(index, c);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    private void throwIfContains(Object element) {
        if (super.contains(element)) {
            throw new IllegalArgumentException(ELEMENT_ALREADY_EXISTS_EXCEPTION);
        }
    }

    private void collectionDuplicateCheck(Collection<? extends E> c) {
        Object[] arr = c.toArray();
        for (int i = 0; i < c.size() - 1; i++) {
            for (int j = i + 1; j < c.size(); j++) {
                if (arr[i].equals(arr[j])) {
                    throw new IllegalArgumentException(DUPLICATE_COLLECTION_ELEMENTS);
                }
            }
        }
    }
}
