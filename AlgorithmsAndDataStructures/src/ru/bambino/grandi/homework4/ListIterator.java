package ru.bambino.grandi.homework4;

import java.util.Iterator;

public interface ListIterator<E> extends Iterator {

    void reset();

    void insertAfter(E value);

    void insertBefore(E value);
}
