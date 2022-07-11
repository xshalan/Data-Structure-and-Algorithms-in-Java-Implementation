package stack;/*
@Author: mohammed.shalan 
@Date: 08-Jul-22
*/

import exception.EmptyStackException;
import interfaces.Stack;

public class NodeStack<T> implements Stack<T> {
    protected Node<T> head;
    protected int size;

    public NodeStack() {
        this.head = null;
        size = 0;
    }

    @Override
    public void push(T object)  {
        head = new Node<>(object,head);
        size++;
    }

    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException("Interface.Stack is empty.");

        Node<T> temp = head;
        size--;
        head = head.getNext();

        return temp.getElement();
    }

    @Override
    public T top() throws EmptyStackException {
        if(isEmpty())
            throw new EmptyStackException("Interface.Stack is empty.");
        return head.getElement();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
