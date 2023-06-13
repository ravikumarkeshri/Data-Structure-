package LinkedList;

import java.util.Random;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private static class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int v, Node n, Node p) {
            value = v;
            next = n;
            prev = p;
        }

        public Node(int data) {
            value = data;
            next = null;
            prev = null;
        }
    }

    public void addHead(int value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addTail(int value) {
        Node newNode = new Node(value);
        Node curr = head;
        if (head == null) {
            head = newNode;
            return;
        }
        while (curr.next != null) {
            curr = curr.next;

        }
        newNode.prev = curr;
        curr.next = newNode;
        newNode.next = null;
        size++;

    }

    public void sortedInsert(int value) {
        Node newNode = new Node(value);
        Node curr = head;
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        if (head.value > value) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return;

        }

        while (curr.next != null && curr.next.value < value) {
            curr = curr.next;
        }
        if (curr.next == null) {
            // tail = newNode;
            newNode.prev = curr;
            curr.next = newNode;
            newNode.next = null;
            size++;
            return;
        }
        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next = newNode;
        newNode.next.prev = newNode;

        size++;
        // return;

    }

    public int removeHead() {

        if (head == null) {
            throw new IllegalStateException("Empty");
        }
        int value = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
            size--;

        }
        return value;
    }
    public boolean removeNode(int key){
        if(head == null){
            tail = null;
            return true;
        }
        Node curr = head;
       while(curr.next!= null){
            if(curr.next.value == key){
                curr.next = curr.next.next;
                if(curr.next == null){
                   tail = curr;
                }else{
                    curr.next.prev = curr;
                    size --;
                    return true;
                }
            }
            curr = curr.next;
       }
       return false;
    }
    public void removeDuplicate(){
        Node curr = head;
        while(curr!=null){
            if(curr.next != null && curr.value == curr.next.value ){
                curr.next = curr.next.next;
                if(curr.next!=null){
                    curr.next.prev = curr;
                }
                if(curr.next == null){
                    tail = curr;
                }

            }else{
                curr = curr.next;

            }
        }
    }
    public void reverseList(){
        Node curr = head;
        Node temp;
        while(curr!= null){
            temp = curr.next;
            curr.next =curr.prev;
            curr.prev = temp;
            if(curr.prev == null){
                tail = head;
                head = curr;
                return;
            }
            curr = curr.prev;
        }
        return ;
    }
    public DoublyLinkedList CopyListReversed(){
        DoublyLinkedList dll2 = new DoublyLinkedList();
        Node curr = head;
        while(curr!= null){
            dll2.addHead(curr.value);
            curr = curr.next;
        }
        return dll2;
    }
    public DoublyLinkedList copyList(){
        DoublyLinkedList dl3 = new DoublyLinkedList();
        Node curr = head;
        while(curr!= null){
            dl3.addTail((curr.value));
            curr =curr.next;

        }return dl3;
    }


    public void printdouble() {
        int count  = 0 ;
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            count++;
            curr = curr.next;

        }
        System.out.println();
        System.out.println( " Count of Node is " + count);
    }

    public static void main(String args[]) {
        System.out.println("Doubly Linked List......");
        DoublyLinkedList dll = new DoublyLinkedList();
        int arr[] = new int[16];
        Random r = new Random(-1);
        for (int i = 0; i < 12; i++) {
            arr[i] = r.nextInt(20);
            dll.sortedInsert(arr[i]);
        }
        boolean removeNode = dll.removeNode(18);
        System.out.println(removeNode);
        // dll.sortedInsert(3);
        dll.printdouble();
        // dll.sortedInsert(21);
        // dll.sortedInsert(23);
        // dll.sortedInsert(30);
        // dll.printdouble();
        // dll.sortedInsert(12);
        // dll.printdouble();
        // dll.reverseList();
        // dll.printdouble();

        // System.out.println("Size of the list : " + dll.size);
        DoublyLinkedList dl2 = new DoublyLinkedList();
        dl2 = dll.CopyListReversed();
        DoublyLinkedList dl3 = dll.copyList();
        dl3.printdouble();
        dl2.printdouble();

    }

}
