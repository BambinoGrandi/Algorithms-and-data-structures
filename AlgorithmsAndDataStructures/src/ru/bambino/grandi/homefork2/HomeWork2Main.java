package ru.bambino.grandi.homefork2;
import ru.bambino.grandi.homefork2.queue.DequeueImpl;

import ru.bambino.grandi.stack.StackImpl;
import ru.bambino.grandi.stack.Stack;

public class HomeWork2Main {

    public static void main(String[] args) {
//        exercises2();
        testDequeue();
    }

    private static void testDequeue(){
        DequeueImpl<Integer> deQueue = new DequeueImpl<>(6);
        System.out.println(deQueue.insert(3));
        System.out.println(deQueue.insert(5));
        System.out.println(deQueue.insert(1));
        System.out.println(deQueue.insert(2));
        System.out.println(deQueue.insert(6));
        System.out.println(deQueue.insert(4));

        System.out.println("Queue peek: " + deQueue.peekFront());
        System.out.println("Queue size: " + deQueue.size());
        System.out.println("Queue is full: " + deQueue.isFull());

        while (!deQueue.isEmpty()) {
            System.out.println(deQueue.remove());
        }

        System.out.println(deQueue.insertRight(3));
        System.out.println(deQueue.insertRight(5));
        System.out.println(deQueue.insertRight(1));
        System.out.println(deQueue.insertRight(2));
        System.out.println(deQueue.insertRight(6));
        System.out.println(deQueue.insertRight(4));


        System.out.println("Queue peekTail: " + deQueue.peekTail());

        while (!deQueue.isEmpty()) {
            System.out.println(deQueue.removeLeft());
        }
    }


    private static void exercises2(){
        String currentText = "Hello World! I love Java!!!";
        System.out.println(currentText);
        StackImpl<Character> stack = new StackImpl<>(currentText.length());
        String flipText = flipLine(currentText, stack);
        System.out.println(flipText);
    }

    private static String flipLine(String text, Stack<Character> stack) {
        char[] flipChar = new char[text.length()];
        String result;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            stack.push(currentChar);
        }
        for (int i = 0; i < flipChar.length; i++) {
            flipChar[i] = stack.pop();
        }
        return result = new String(flipChar);
    }

}
