package ru.bambino.grandi.linkedlist;

import java.util.Iterator;
import java.util.ListIterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected int size;


    @Override
    public void insertFirst(E value) {
        Entry<E> entry = new Entry<>(value);
        entry.next = firstElement;
        firstElement = entry;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()){
            return null;
        }

        E removedValue = firstElement.value;
        firstElement = firstElement.next;
        size--;
        return removedValue;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> current = firstElement;
        Entry<E> previous = null;
        while(current != null){
            if (current.value.equals(value)) break;
            previous = current;
            current = current.next;
        }


        if (current == null) return false;
        if (current == firstElement) firstElement = firstElement.next;
        else previous.next = current.next;

        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Entry<E> current = firstElement;
        while (current != null){
            if (current.value.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        System.out.println("****************");
        Entry<E> current = firstElement;
        while (current != null){
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println("****************");

    }

    @Override
    public E getFirst() {
        return firstElement != null ? firstElement.value : null;
    }

    @Override
    public Entry<E> getFirstElement() {
        return firstElement;
    }

    @Override
    public Iterator<E> iterator() {

        return new IteratorList<>(this);
    }

    private class IteratorList<E> implements Iterator<E> {

        private final SimpleLinkedListImpl<E> list;

        Entry<E> current;
        Entry<E> previous;

        public IteratorList(SimpleLinkedListImpl<E> list) {
            this.list = list;
            this.reset();
        }

       public boolean atEnd(){
            return (current.next == null);
       }


       public void insertAfter(E value){
            Entry<E> newValue = new Entry<>(value);
            if (list.isEmpty()){
                list.firstElement = newValue;
                current = newValue;
            }else{
                newValue.next = current.next;
                current.next = newValue;
                next();
            }
       }

       public void insertBefore(E value){
            Entry<E> newValue = new Entry<>(value);
            if (previous == null){
                newValue.next = list.firstElement;
                list.firstElement = newValue;
                reset();
            }else{
                newValue.next = previous.next;
                previous.next = newValue;
                current = newValue;
            }
       }

       public void remove(){
            if (previous == null){
                list.firstElement = current.next;
                reset();
            }else {
                previous.next = current.next;

                if (!hasNext()) reset();
                else current = current.next;
            }
       }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {

            E nextValue = current.value;
            previous = current;
            current = current.next;
            return nextValue;
        }

        public void reset() {
            current = list.firstElement;
            previous = null;
        }
    }
}
