package main.de.hawhamburg.krukenberg_benlemlih.a05.denksport;

public class LinkedList<E> {
    private Node head = null;

    private class Node {
        E value;
        Node next;// Node constructor links the node as a new head

        Node(E value) {
            this.value = value;
            this.next = head;
            head = this;
        }
    }

    public void add(E e) {
        new Node(e);// Link node as new head
    }

    public void dump() {
        for (Node n = head; n != null; n = n.next) {
            System.out.println(n.value + " ");
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("world");
        list.add("Hello");
        list.dump();
    }
}