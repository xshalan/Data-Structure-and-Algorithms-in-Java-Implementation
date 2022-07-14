/*
@Author: mohammed.shalan 
@Date: 14-Jul-22
*/

import Exceptions.EmptyQueueException;
import Exceptions.FullQueueException;
import Interfaces.Queue;

public class ArrayQueue<T> implements Queue<T> {
    private static int CAPACITY = 1000;
    private int size;
    private int front = 0;
    private int next = 0;
    private T[] array;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int size) {
        this.size = size;
        array = (T[]) new Object[size];
    }

    @Override
    public int size() {
        return (isEmpty()) ? 0 : next-front;
    }

    @Override
    public boolean isEmpty() {
        return next==front;
    }

    @Override
    public T getFront() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException("The Queue is Empty!");
        return array[front];
    }

    @Override
    public void enqueue(T element) {
        if (next < array.length) {
            array[next++] = element;
        } else {
            throw new FullQueueException("The Queue is full!");
        }
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty() || front == next)
            throw new EmptyQueueException("The Queue is empty!");

        return array[front++];
    }
}
