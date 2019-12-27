package com.sethjava.linkedlist;

import java.util.LinkedList;

public class SinglyLinkedListDemo {

    public static void main(String[] args) {
	    CustomLinkedList linkedList = new CustomLinkedList();

        linkedList.add("John");
        linkedList.add("David");
        linkedList.addFirst("Claire");
        linkedList.add("Andrew");
        linkedList.printList();
        System.out.println("");
        linkedList.add("Becky", 4);
        System.out.println(linkedList.size());
        linkedList.printList();

        System.out.println("");
        Object object = linkedList.find(2);
        System.out.println("Found Node " + object);

        Node deletedNode = linkedList.removeLast();
        System.out.println("");
        linkedList.printList();
        System.out.println("");
        System.out.println("Deleted Node "+ deletedNode);

        deletedNode = linkedList.removeFirst();
        System.out.println("");
        linkedList.printList();
        System.out.println("");
        System.out.println("Deleted Node "+ deletedNode);

        deletedNode = linkedList.remove(0);
        System.out.println("");
        linkedList.printList();
        System.out.println("");
        System.out.println("Deleted Node "+ deletedNode);

        linkedList.remove("Andrew");
        System.out.println("");
        linkedList.printList();
        System.out.println("");

    }
}
