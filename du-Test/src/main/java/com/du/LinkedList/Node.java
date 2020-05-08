package com.du.LinkedList;

public class Node<E> {

    E element;
    Node<E> next;
    Node<E> prev;


    Node(Node<E> prev,E element,Node<E> next){
        this.prev = prev;
        this.element = element;
        this.next = next;
    }


}
