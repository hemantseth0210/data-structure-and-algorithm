package com.sethjava.linkedlist;

public class Node {
    // Data carried by this..could be of any type
    private Object data;
    // Reference to the next node
    private Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
