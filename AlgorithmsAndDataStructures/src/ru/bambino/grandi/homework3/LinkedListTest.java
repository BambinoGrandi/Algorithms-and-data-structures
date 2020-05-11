package ru.bambino.grandi.linkedlist;

public class LinkedListTest {

    public static void main(String[] args) {
        testLinkedList();
    }

    private static void testLinkedList() {
        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();

        linkedList.insertFirst(11111);
        linkedList.insertFirst(121);
        linkedList.insertFirst(0);
        linkedList.insertFirst(2321);
        linkedList.insertFirst(211);
        linkedList.insertFirst(2232);
        linkedList.insertFirst(233);
        linkedList.insertFirst(3);

        linkedList.display();

        System.out.println("Найти 0 " + linkedList.contains(0));
        System.out.println("Найти 82812818 " + linkedList.contains(82812818));

        linkedList.removeFirst();
        linkedList.remove(2232);

        linkedList.display();

        for (Integer integer : linkedList) {
            System.out.println(integer);
        }

        linkedList.iterator();




    }

}
