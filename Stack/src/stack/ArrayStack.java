package stack;/*
@Author: mohammed.shalan 
@Date: 08-Jul-22
*/

import exception.EmptyStackException;
import exception.FullStackException;
import interfaces.Stack;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    protected int capacity;
    protected static final int CAPACITY = 100; // NOTE: Should be static to use constructor chain
    private T[] S;
    private int top = -1; // Interface.Stack is Empty

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        S = (T[]) new Object[capacity];
    }

    @Override
    public void push(T object) throws FullStackException {
        if (top < capacity) {
            S[++top] = object;
        } else {
            throw new FullStackException("The stack is full!.");
        }
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("The stack is empty.");
        T temp = S[top];
        S[top] = null;
        --top;
        return temp;
    }

    @Override
    public T top() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException("The stack is empty.");
        return S[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(S);
    }
}
