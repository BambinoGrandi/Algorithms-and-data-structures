package ru.bambino.grandi.comparesorts;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainArray {

    public static void main(String[] args) {

        int [] temp = new int[100_000];

        MyArray<Integer> arraySB = new MyArray<>();
        MyArray<Integer> arraySS = new MyArray<>();
        MyArray<Integer> arraySI = new MyArray<>();

        for (int i = 0; i < temp.length; i++) {
            temp[i] = i * new Random().nextInt();
        }

        for (int i = 0; i < temp.length; i++) {
            arraySB.add(temp[i]);
        }for (int i = 0; i < temp.length; i++) {
            arraySS.add(temp[i]);
        }for (int i = 0; i < temp.length; i++) {
            arraySI.add(temp[i]);
        }

//        timeOfSortBubble(arraySB);
//        timeOfSortSelect(arraySS);
        timeOfSortInsert(arraySI);
    }

    private static void timeOfSortBubble(MyArray array){
        long start = System.nanoTime();
        array.sortBubble();
        long finish = System.nanoTime();
        long result = finish - start;
        long milliSec = TimeUnit.NANOSECONDS.toMillis(result);
        System.out.println("Результат сортировки пузырком " + milliSec + " милисек");

    } private static void timeOfSortSelect(MyArray array){
        long start = System.nanoTime();
        array.sortSelect();
        long finish = System.nanoTime();
        long result = finish - start;
        long milliSec = TimeUnit.NANOSECONDS.toMillis(result);
        System.out.println("Результат сортировки выборки " + milliSec + " милисек");

    } private static void timeOfSortInsert(MyArray array){
        long start = System.nanoTime();
        array.sortInsert();
        long finish = System.nanoTime();
        long result = finish - start;
        long milliSec = TimeUnit.NANOSECONDS.toMillis(result);
        System.out.println("Результат сортировки вставки " + milliSec + " милисек");
    }

}
