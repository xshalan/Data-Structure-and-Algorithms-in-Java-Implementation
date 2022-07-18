package Interfaces;

import Exceptions.EmptyDequeException;

/*
@Author: mohammed.shalan 
@Date: 18-Jul-22
*/
// Double-Ended Queue
public interface Deque<T> {
    /**
     * Get size of deque
     * @return the number of elements in deque
     */
    int size();

    /**
     * Insert an element to be the first in the deque.
     * @param element to be inserted
     */
    void addFirst(T element);

    /**
     * Insert an element to be the last in the deque.
     * @param element to be inserted
     */
    void addLast(T element);

    /**
     *  Remove the first element in the deque
     * @return The removed element
     * @throws EmptyDequeException
     */
    T removeFirst() throws EmptyDequeException;

    /**
     * Remove the last element in the deque
     * @return The removed element
     * @throws EmptyDequeException
     */
    T removeLast() throws EmptyDequeException;

    /**
     *
     * @return Object represent the first element in the deque
     * @throws EmptyDequeException
     */
    T getFirst() throws EmptyDequeException;

    /**
     *
     * @return Object represent the last element in the deque
     * @throws EmptyDequeException
     */
    T getLast() throws EmptyDequeException;

    /**
     *  Check whether the deque is empty or not
     * @return True if the deque is empty, otherwise False
     */
    boolean isEmpty();
}
