/*
@Author: mohammed.shalan 
@Date: 18-Jul-22
*/

import Exceptions.EmptyQueueException;
import Interfaces.Queue;

public class NodeQueue<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;

    private int size;

    public NodeQueue() {
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);

        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T getFront() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException("The queue is empty.");
        return head.getElement();
    }

    @Override
    public void enqueue(T element) {
        Node<T> node = new Node<>(element, null);
        if (size == 0)
            head = node;
        else
            tail.setNext(node);
        tail = node;
        size++;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException("The Queue is empty");
        T temp = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return temp;
    }
}
