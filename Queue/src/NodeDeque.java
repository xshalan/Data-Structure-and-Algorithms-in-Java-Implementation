/*
@Author: mohammed.shalan 
@Date: 18-Jul-22
*/

import Exceptions.EmptyDequeException;
import Interfaces.Deque;

public class NodeDeque<T> implements Deque<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public NodeDeque() {
        head = new Node<>(null,null);
        tail = new Node<>(null,null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T element) {
        Node<T> node = new Node<>(element);
        if(size==0){
            node.setNext(tail);
            tail=node;
            node.setPrev(null);
        }else{
            Node<T> headTemp = head;
            node.setPrev(null);
            headTemp.setPrev(node);
            node.setNext(headTemp);

        }
        head = node;
        size++;

    }

    @Override
    public void addLast(T element) {
        Node<T> node = new Node<>(element,null);
        if(size==0){
            node.setNext(null);
            head=node;
        }else{
            node.setNext(null);
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
        size++;
    }

    @Override
    public T removeFirst() throws EmptyDequeException {
        if(size==0)
            throw new EmptyDequeException("The deque is empty.");
        T element = head.getElement();
        head.getNext().setPrev(null);
        head = head.getNext();
        return element;
    }

    @Override
    public T removeLast() throws EmptyDequeException {
        if(size==0)
            throw new EmptyDequeException("The deque is empty.");
        T element = tail.getElement();
        tail.getPrev().setNext(null);
        tail = tail.getPrev();

        return element;
    }

    @Override
    public T getFirst() throws EmptyDequeException {
        return head.getElement();
    }

    @Override
    public T getLast() throws EmptyDequeException {
        return tail.getElement();
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        Node<T> pointer = head;
        StringBuilder result = new StringBuilder();
        while (pointer!=null){
            result.append(" -> ").append(pointer.getElement().toString());
            pointer = pointer.getNext();
        }

        return result.toString();
    }
}
