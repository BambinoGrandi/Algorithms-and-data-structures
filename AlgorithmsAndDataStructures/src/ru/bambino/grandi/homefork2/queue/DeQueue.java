package ru.bambino.grandi.homefork2.queue;

public interface DeQueue<E> {

    boolean insertRight (E value);

    E removeLeft();

    E peekTail();

}
