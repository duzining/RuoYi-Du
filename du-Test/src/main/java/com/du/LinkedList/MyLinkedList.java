package com.du.LinkedList;



import java.util.Collection;

public class MyLinkedList<E> {

    transient int size = 0;

    transient Node<E> last;

    public MyLinkedList(){};

    public MyLinkedList( Collection<? extends E> c){
        this();

    }

    public boolean addAll(Collection<? extends E> c){
        return false;
    }

    public boolean addAll(int index,Collection<? extends E> c){
        if (!(index >=0 && index <= size)){
            throw new IndexOutOfBoundsException("index:" + index+",size:"+ size);
        }

        Object [] o = c.toArray();
        int numNew = c.size();
        if (numNew == 0){
            return  false;
        }

        Node<E> pred,succ;

        if (index == c.size()){
            succ = null;
            pred = last;
        }else {
            return false;
        }

        return true;
    }

}
