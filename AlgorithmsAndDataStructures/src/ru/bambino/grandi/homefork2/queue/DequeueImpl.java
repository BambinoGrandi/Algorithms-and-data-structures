package ru.bambino.grandi.homefork2.queue;

public class DequeueImpl<E> extends QueueImpl<E> implements DeQueue<E>{



    private int headRight;
    private int tailLeft;

    public DequeueImpl(int maxSize) {
        super(maxSize);
        this.headRight = lastIndex();
        this.tailLeft = data.length;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) return false;

        if (tailLeft == 0) {
            tailLeft = data.length;
            return false;
        }


        data[--tailLeft] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }

        if (headRight == 0) {
            headRight = lastIndex();
        }

        E removedValue = data[headRight--];
        size--;
        return removedValue;
    }

    @Override
    public E peekTail() {
        return data[headRight];
    }
}
