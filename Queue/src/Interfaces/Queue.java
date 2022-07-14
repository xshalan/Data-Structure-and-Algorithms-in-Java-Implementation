package Interfaces;
/* 
@Author: mohammed.shalan 
@Date: 14-Jul-22
*/

import Exceptions.EmptyQueueException;

public interface Queue<E>{

    public int size();
    public boolean isEmpty();
    public E getFront() throws EmptyQueueException;
    public void enqueue(E element);
    public E dequeue() throws EmptyQueueException;



}
