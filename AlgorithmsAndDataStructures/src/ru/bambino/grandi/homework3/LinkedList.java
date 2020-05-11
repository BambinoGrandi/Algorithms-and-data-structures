package ru.bambino.grandi.linkedlist;

public interface LinkedList<E> extends Iterable<E>{

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    default boolean isEmpty(){return size() == 0;}

    int size();

    void display();

    E getFirst();

    Entry<E> getFirstElement();

    class Entry<E>{
        public E value;
        public Entry<E> next;

        public Entry(E value){this.value = value;}
    }

}
