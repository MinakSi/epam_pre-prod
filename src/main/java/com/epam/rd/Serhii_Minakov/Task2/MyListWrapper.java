package com.epam.rd.Serhii_Minakov.Task2;

import com.epam.rd.Serhii_Minakov.Task1.first.Goods;
import com.epam.rd.Serhii_Minakov.Task1.second.MyList;

import java.util.*;

/**
 * This class implements List.
 * Consists on two arrays: modifiable and unmodifiable.
 * Unmodifiable part sets only once in constructor and can not be modified during working process.
 * Modifiable part can be changed in any way.
 * User cannot modify unmodifiable or modifiable part of this wrapper directly.
 *
 * @param <E> the type of elements in this list
 * @author Serhii_Minakov
 * @see List
 */
public class MyListWrapper<E extends Goods> implements List<E> {

    private final MyList<E> unmodifiable;
    private final MyList<E> modifiable;

    public MyListWrapper(MyList<E> unmodifiable, MyList<E> modifiable) {
        this.unmodifiable = unmodifiable;
        this.modifiable = modifiable;
    }

    public MyListWrapper(MyList<E> unmodifiable) {
        this.unmodifiable = unmodifiable;
        this.modifiable = new MyList<>();
    }

    public MyListWrapper() {
        this.unmodifiable = new MyList<>();
        this.modifiable = new MyList<>();
    }

    @Override
    public int size() {
        return unmodifiable.size() + modifiable.size();
    }

    @Override
    public boolean isEmpty() {
        return unmodifiable.isEmpty() || modifiable.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return unmodifiable.contains(o) || modifiable.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    @Override
    public Object[] toArray() {
        return mergeLists().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return mergeLists().toArray(a);
    }

    @Override
    public boolean add(E e) {
        return modifiable.add(e);
    }

    /**
     * removes the first occurrence of the specified element from this list,
     * if it is present and if it is only in the modifiable part.
     * If this list does not contain the element, it is unchanged.
     *
     * @param o element to be removed from this list, if present only in modifiable part
     * @return {@code true} if this element was successfully removed.
     * @throws IllegalArgumentException if the first occurrence of the specified element is in unmodifiable part.
     */
    @Override
    public boolean remove(Object o) {
        if (unmodifiable.contains(o)){
            throw new IllegalArgumentException("object is in range of unmodifiable part");
        }
        return modifiable.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return mergeLists().containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return modifiable.addAll(c);
    }

    /**
     * Inserts all of the elements in the specified collection into this
     * list at the specified position if and only if index is not in range
     * of unmodifiable list.  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (increases their indices).
     *
     * @param index index at which to insert the first element from the specified collection
     * @param c collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws IllegalArgumentException if inserting position is in range of unmodifiable list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index<0||index>size()){
            throw new IndexOutOfBoundsException();
        }
        if (modifiableIndex(index)) {
            modifiable.addAll(index - unmodifiable.size(), c);
            return true;
        }
        throw new IllegalArgumentException("index is in range of unmodifiable part");
    }

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection if and only if unmodifiable part contains no of
     * the elements specified in the collection.
     *
     * @param c collection containing elements to be removed from this list
     * @return {@code true} if this list changed as a result of the call
     * @throws IllegalArgumentException if unmodifiable part contains any of the elements from the collection
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o: c){
            if (unmodifiable.contains(o)){
                throw new IllegalArgumentException("object is in range of unmodifiable part");
            }
        }
        modifiable.removeAll(c);
        return true;
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection if and only if every element in the unmodifiable part exists in the
     * collection.
     * @param c collection containing elements to be retained in this list
     * @return {@code true} if this list changed as a result of the call
     * @throws IllegalArgumentException if object to be removed is in range of unmodifiable part
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object o: unmodifiable){
            if (!c.contains(o)){
                throw new IllegalArgumentException("object to be removed is in range of unmodifiable part");
            }
        }
        modifiable.retainAll(c);
        return true;
    }

    @Override
    public void clear() {
        modifiable.clear();
    }

    @Override
    public E get(int index) {
        return mergeLists().get(index);
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element if and only if the element to be modified is not in range of unmodifiable part.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IllegalArgumentException if index is in range of unmodifiable part
     */
    @Override
    public E set(int index, E element) {
        if (modifiableIndex(index)) {
            return modifiable.set(index - unmodifiable.size(), element);
        }
        throw new IllegalArgumentException("index is in range of unmodifiable part");
    }

    /**
     * Inserts the specified element at the specified position in this list if and only if
     * the index is not in range of unmodifiable part.
     * Shifts the element currently at that position
     * (if any) and any subsequent elements to the right.
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IllegalArgumentException if index is in range of unmodifiable part
     */
    @Override
    public void add(int index, E element) {
        if (modifiableIndex(index)) {
            modifiable.add(index - unmodifiable.size(), element);
        } else {
            throw new IllegalArgumentException("index is in range of unmodifiable part");
        }

    }

    /**
     * Removes the element at the specified position in this list if and only if
     * index is not in range of unmodifiable part.
     * Shifts any subsequent elements to the left.
     * Returns the element that was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IllegalArgumentException if index is in range of unmodifiable part
     */
    @Override
    public E remove(int index) {
        if (modifiableIndex(index)) {
            return modifiable.remove(index - unmodifiable.size());
        }
        throw new IllegalArgumentException("index is in range of unmodifiable part");
    }

    @Override
    public int indexOf(Object o) {
        return mergeLists().indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return mergeLists().lastIndexOf(o);
    }

    private class IteratorImpl implements Iterator<E> {

        private int cursor; //next item

        public IteratorImpl() {
            cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return mergeLists().size() != cursor;
        }

        @Override
        public E next() {
            return mergeLists().get(cursor++);
        }

        @Override
        public void remove() {
            if (cursor<unmodifiable.size()){
                throw new IllegalStateException();
            }
            modifiable.remove(cursor-unmodifiable.size());
        }
    }

    private MyList<E> mergeLists() {
        MyList<E> list = new MyList<>();
        list.addAll(unmodifiable);
        list.addAll(modifiable);
        return list;
    }

    private boolean modifiableIndex(int index) {
        return index >= unmodifiable.size();
    }

    //stub///////////////////////////////////////
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
    //stub///////////////////////////////////////

}
