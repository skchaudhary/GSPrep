package com.gs.util;

public class Node<E> {
    public Node next, prev;
    public E data;
    public Node(E e) {
        prev=next=null;
        this.data = e;
    }
}
