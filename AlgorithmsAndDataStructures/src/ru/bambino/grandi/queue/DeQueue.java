package ru.bambino.grandi.queue;

public interface DeQueue<E> {

    boolean insertRight (E value);

    E removeLeft();

    E peekTail();

}
