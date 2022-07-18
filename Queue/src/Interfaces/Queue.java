package Interfaces;
/* 
@Author: mohammed.shalan 
@Date: 14-Jul-22
*/

import Exceptions.EmptyDequeException;
import Exceptions.EmptyQueueException;

public interface Queue<E>{
    /**
     * Get the size of queue
     * @return the number of elements in queue
     */
     int size();

    /**
     *  Check whether the queue is empty or not
     * @return True if the queue is empty, otherwise False
     */
     boolean isEmpty();
    /**
     *
     * @return Object represent the first element in the queue
     * @throws EmptyQueueException
     */
     E getFront() throws EmptyQueueException;

    /**
     * Insert an element to be the last in the queue.
     * @param element to be inserted
     */
     void enqueue(E element);

    /**
     *  Remove the first element in the queue
     * @return The removed element
     * @throws EmptyQueueException
     */
     E dequeue() throws EmptyQueueException;



}
