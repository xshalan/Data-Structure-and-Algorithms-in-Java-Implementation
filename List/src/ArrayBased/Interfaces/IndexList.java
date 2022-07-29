package ArrayBased.Interfaces;
/* 
@Author: mohammed.shalan 
@Date: 28-Jul-22
*/

import ArrayBased.Exceptions.IndexOutOfBoundsException;

public interface IndexList<E>{
    /**
     * The number of the inserted elements in the list
     * @return Number of elements in list
     */
    public int size();

    /**
     * Specificy whether the list is empty or not
     * @return True if the list is empty otherwise, False
     */
    public boolean isEmpty();

    /**
     * Insert an element in the specific index i
     * @param index Index where the element will be inserted
     * @param element The new element
     * @throws IndexOutOfBoundsException
     */
    public void add(int index,E element) throws IndexOutOfBoundsException;

    /**
     * Replace an element at index i with another element and return the removed one.
     * @param index Index where the element will be replaced
     * @param element The new element
     * @return The removed element
     * @throws IndexOutOfBoundsException
     */
    public E set(int index,E element) throws IndexOutOfBoundsException;
    /**
     * remove an element at index i and return the removed one.
     * @param index Index where the element will be removed
     * @return The removed element
     * @throws IndexOutOfBoundsException
     */
    public E remove(int index) throws IndexOutOfBoundsException;
    /**
     * Return an element at the specific index i
     * @param index index of the element
     * @throws IndexOutOfBoundsException
     */
    public E get(int index) throws IndexOutOfBoundsException;
}
