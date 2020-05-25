package de.hawhamburg.krukenberg_benlemlih.a05.denksport;

public class LinkedList<E> {
    private Node<E> head = null;

    static private class Node<E> {
        E value;
        Node<E> next;// Node constructor links the node as a new head

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(E e) {
head = new Node<>(e, head);// Link node as new head
    }

    public void dump() {
        for (Node<E> n = head; n != null; n = n.next) {
            System.out.println(n.value + " ");
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("world");
        list.add("Hello");
        list.dump();
    }
}