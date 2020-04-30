package ru.bambino.grandi.comparesorts;

import java.util.Arrays;

public class MyArray<E extends Object & Comparable<? super E>> implements Array<E>{

    private E[] data; //Массив для хранения
    private int size;//Размер массива

    public MyArray(int initialCapacity) { this(null, initialCapacity);} //инициализация пустого массива

    public MyArray(E... data) {
        this(data, data.length);
        this.size = data.length;
    }

    public MyArray() { this(null, INITIAL_CAPACITY);}

    private MyArray(E[] data, int capacity) {
        this.size = data != null ? data.length : 0; //Выбор размера массива если данных нет - размер равен 0
        this.data = data != null ? data : (E[]) new Object[capacity]; //Приведение данных в массиве к объектам
    }

    @Override
    public void add(E value) {
        checkAndGrow();
        data[size++] = value;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        try {
            return remove(index) != null;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedValue = data[index]; //Запоминаем значение
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1]; //Сдвигам массив влево
        }
        data[size - 1] = null;// Удаляем дублирующее значение в массиве, чтобы не было копий
        size--; // Уменьшаем размер массива
        return removedValue; //Возвращаем удаленный элемент
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) return i; //Если есть значение возвращаем его
        }
        return -1; //Если нет -1
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) { //Если элемент больше следующего, меняем их местами
                    swap(j, j + 1);
                }
            }
        }
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i; //Запоминаем минимальный индекс
            for (int j = i + 1; j < size; j++) { //Берем следующий индекс после минимального
                //Если элемент меньше минимального, запоминаем его
                if (data[j].compareTo(data[minIndex]) < 0) minIndex = j;
            }
            //Если минимальное значение не равно, меняем их местами
            if (minIndex != i) swap(minIndex, i);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 0; i < size; i++) {
            E temp = data[i]; //Запоминаем первое значение массива
            int in = i; //Запоминаем индекс
            while (in > 0 && data[in - 1].compareTo(temp) > 0) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }

    private void swap(int index1, int index2) {
        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    private void checkAndGrow() {
        if (data.length == size){
            data = Arrays.copyOf(data, data.length * 2);//Если данных больше размера массива - увеличить в два раза
        }
    }

    private void checkIndex(int index) { //Проверяем корректный ли индекс
        if (index < 0 || index > data.length){
            String errorMsg = String.format("Invalid index %d for array with size %d", index, size);
            throw new IndexOutOfBoundsException(errorMsg);
        }
    }
}
