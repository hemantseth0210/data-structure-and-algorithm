package com.sethjava.linkedlist;

public class CustomLinkedList {
    private Node head;
    private static int size = 0;

    // appends the node to end of list
    public void add(Object data){
        Node newNode = new Node(data);
        // If the Linked List is empty, then make the new node as head
        if(head == null){
            head = newNode;
        } else {
            Node currentNode = head;
            // Traverse to the end of the list
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        // increment the size
        size++;
    }

    // Append the node to the front of the list
    public void addFirst(Object data){
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;

        // increment the size
        size++;
    }

    // inserts the specified element at the specified position in this list
    public void add(Object data, int index) {
        if(index > size)
            throw new IndexOutOfBoundsException("Index " + index + " doesn't exist in CustomLinkedList");
        Node newNode = new Node(data);
        // If the Linked List is empty, then make the new node as head
        if(index == 0){
            newNode.setNext(head);
            head = newNode;
        } else {
            Node currentNode = head;
            if(currentNode != null){
                for(int i = 0; i < index - 1 && currentNode.getNext() != null; i++){
                    currentNode = currentNode.getNext();
                }
            }
            // set the new node's next-node reference to this node's next-node reference
            newNode.setNext(currentNode.getNext());
            // now set this node's next-node reference to the new node
            currentNode.setNext(newNode);
        }
        // increment the size
        size++;
    }

    // Remove the Node from the end of the list.
    public Node removeLast(){
        // If linkedlist is empty
        if(head == null)
            System.err.println("Error:  Attempt to remove from an empty CustomLinkedList");
        // It holds the last node
        Node removedNode = head;
        // It holds the second last node
        Node previousNode = null;
        while(removedNode.getNext() != null){
            previousNode = removedNode;
            removedNode = removedNode.getNext();
        }
        // In case of single node previous node will be null so we return null linkedlist
        if(previousNode == null)
            head = null;
        else
            previousNode.setNext(null);

        // decrement the size
        size--;
        return removedNode;
    }

    // Remove the Node from the front of the list.
    public Node removeFirst(){
        // If linkedlist is empty
        if(head == null)
            System.err.println("Error:  Attempt to remove from an empty CustomLinkedList");
        Node removedNode = head;
        head = head.getNext();
        removedNode.setNext(null);

        // decrement the size
        size--;
        return removedNode;
    }

    // Remove the node from the given position
    public Node remove(int index){
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index " + index + " doesn't exist in CustomLinkedList");
        Node removedNode = null;
        Node currentNode = head;
        // If head needs to be removed
        if(index == 0){
            removedNode = currentNode;
            head = currentNode.getNext();
            removedNode.setNext(null);
        } else {
            for(int i = 0; i < index - 1 && currentNode.getNext() != null; i++){
                currentNode = currentNode.getNext();
            }
            removedNode = currentNode.getNext();
            currentNode.setNext(removedNode.getNext());
            removedNode.setNext(null);
        }

        // decrement the size
        size--;
        return removedNode;
    }

    //Removes the first occurrence of the specified element from this list, if it is present.
    public boolean remove(Object data){
        Node currentNode = head;
        Node previousNode = null;

        // If head node itself holds the key to be deleted
        if(currentNode != null && currentNode.getData().equals(data)){
            head = currentNode.getNext();
            size--;
            return true;
        }

        // Search for the key to be deleted, keep track of the previous node as we need to change reference
        while(currentNode != null && !currentNode.getData().equals(data)){
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        // If key was not present in linked list
        if(currentNode == null)
            return false;
        previousNode.setNext(currentNode.getNext());
        currentNode.setNext(null);

        // decrement the size
        size--;
        return true;
    }

    // Delete the complete LinkedList
    public void removeAll(){
        head = null;
    }

    /* Returns count of nodes in linked list */
    public int getNodeCount(){
        Node currentNode = head;
        int count = 0;
        while(currentNode != null){
            count++;
            currentNode = currentNode.getNext();
        }
        return count;
    }

    /* Returns count of nodes in linked list */
    public int getNodeCountRec(Node node)
    {
        // Base case
        if (node == null)
            return 0;

        // Count is this node plus rest of the list
        return 1 + getNodeCountRec(node.getNext());
    }

    //Checks whether the data is present in linked list
    public boolean search(Object data)
    {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData().equals(data))
                return true;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    // Find the Nth Node
    public Object find(int index){
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index " + index + " doesn't exist in CustomLinkedList");
        Node currentNode = head;
        for(int i = 0; i < index && currentNode != null ; i++){
            currentNode = currentNode.getNext();
        }
        if(currentNode != null)
            return currentNode.getData();
        else
            return null;
    }

    public int size(){
        return size;
    }
    public void printList(){
        Node currentNode = head;
        System.out.print("HEAD -> ");
        while (currentNode != null){
            System.out.print(currentNode.getData());
            System.out.print(" -> ");
            currentNode = currentNode.getNext();
        }
        System.out.print(" NULL ");
    }


    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
}
