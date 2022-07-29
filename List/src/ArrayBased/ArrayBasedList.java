package ArrayBased;
/* 
@Author: mohammed.shalan 
@Date: 28-Jul-22
*/

import ArrayBased.Exceptions.IndexOutOfBoundsException;
import ArrayBased.Interfaces.IndexList;

public class ArrayBasedList<E> implements IndexList<E> {
    private int size;
    private int capacity;
    private E[] array;

    public ArrayBasedList() {
        size = 0;
        capacity = 20;
        array = (E[]) new Object[capacity];
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
    public void add(int index, E element) throws IndexOutOfBoundsException {
        // check if the index in the range of the list
        checkIndex(index, Operation.ADD);
        if (size == capacity) {
            // overflow occurs
            capacity *= 2;
            E[] B = (E[]) new Object[capacity];
            // copy the elements from the old array to the new one.
            for (int i = 0; i < array.length; i++) {
                B[i] = array[i];
            }
            array = B; // make old array refers to the new array reference
        }
        // shift all elements right starting at the specific index.
        shiftArray(index, Operation.ADD);
        array[index] = element;
        size++;


    }

    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index,null);
        E tempElement = array[index];
        array[index] = element;
        return tempElement;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index,Operation.REMOVE);
        E tempElement = array[index];
        // shift all elements right starting at the specific index.
        shiftArray(index, Operation.REMOVE);
        size--;
        return tempElement;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index,Operation.ADD);
        return array[index];
    }

    private void checkIndex(int index, Operation operation) {

        if (operation == Operation.ADD) {
            if (!(index < size() + 1 && index >= 0)) {
                throw new IndexOutOfBoundsException("Index out of the list bounds");
            }
        }

        if (operation == Operation.REMOVE) {
            if (!(index < size() && index >= 0)) {
                throw new IndexOutOfBoundsException("Index out of the list bounds");
            }
        }

    }



    private void shiftArray(int index, Operation operation) {
        if (operation == Operation.ADD && size >= 1) {
            for (int i = size() - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }
        }

        if (operation == Operation.REMOVE && size >= 1) {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
        }
    }


    private enum Operation {
        ADD, REMOVE
    }

}
