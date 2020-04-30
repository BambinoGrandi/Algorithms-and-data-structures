package ru.bambino.grandi.comparesorts;

public interface Array<E> {

    int INITIAL_CAPACITY = 16; //Начальный размер массива

    void add(E value); //Добавление в массив

    E get(int index); //Получение элемента

    boolean remove(E value); //Удаление элемента по значнию
    E remove(int index); //Удаление по индексу

    default boolean contains(E value) { return indexOf(value) != -1;} //Поиск элемента по значению

    int indexOf(E value); //Поиск индекса элемента по значению

    int size(); //Возвращает размер массива

    default boolean isEmpty(){return size() == 0;} //True если массив пустой

    default void display() { //Вывод массива в консоль
        System.out.println("[");
        for (int i = 0; i < size(); i++) {
            E value = get(i);
            System.out.println(value);
        }
        System.out.println("]");
    }

    void sortBubble();//Сортирует массив пузырьком
    void sortSelect();//Сортирует массив выборкой
    void sortInsert();//Сортирует массив вставкой
}
