package com.gs.ds;


import com.gs.util.Node;

public class ImplementDeque<E> {
    Node<E> first, last;
    int size;
    public ImplementDeque() {
        first=last=null;
        size=0;
    }
    public void addFirst(E e) {
        if (first==null) {
            first=last=new Node(e);
        } else {
            Node f = new Node(e);
            f.next=first;
            first.prev=f;
            first = f;
        }
        size++;
    }
    public void addLast(E e) {
        if (last==null) {
            first=last=new Node(e);
        } else {
            Node f = new Node(e);
            f.prev=last;
            last.next=f;
            last = f;
        }
        size++;
    }

    public E getFirst(E e) throws Exception {
        if (first!=null) {
            return first.data;
        }
        throw new Exception("Deque id empty");
    }
    public E getLast(E e) throws Exception {
        if (last!=null) {
            return last.data;
        }
        throw new Exception("Deque id empty");
    }

    public E pollFirst(E e) throws Exception {
        if (first!=null) {
            Node<E> f = first;

            first=first.next;
            if (first!=null) {
                first.prev = null;
            } else {
                last=null;
            }
            f.next = null;
            size--;
            return f.data;
        }
        throw new Exception("Deque id empty");
    }
    public E pollLast(E e) throws Exception {
        if (last!=null) {
            Node<E> f = last;

            last=last.prev;
            if (last!=null) {
                last.next = null;
            } else {
                first=null;
            }
            f.prev = null;
            size--;
            return f.data;
        }
        throw new Exception("Deque id empty");
    }

    public void removeFirst(E e) throws Exception {
        if (first!=null) {
            Node<E> f = first;

            first=first.next;
            if (first!=null) {
                first.prev = null;
            } else {
                last=null;
            }
            f.next = null;
            size--;
        }
        throw new Exception("Deque id empty");
    }
    public void removeLast(E e) throws Exception {
        if (last!=null) {
            Node<E> f = last;

            last=last.prev;
            if (last!=null) {
                last.next = null;
            } else {
                first=null;
            }
            f.prev = null;
            size--;
        }
        throw new Exception("Deque id empty");
    }

    public int size() {
        return size;
    }
}
