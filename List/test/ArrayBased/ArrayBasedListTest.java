package ArrayBased;

import ArrayBased.Exceptions.IndexOutOfBoundsException;
import ArrayBased.Interfaces.IndexList;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/* 
@Author: mohammed.shalan 
@Date: 28-Jul-22
*/

public class ArrayBasedListTest {
    private IndexList<Integer> list ;
    @Before
    public void setup(){
        list = new ArrayBasedList<>();
    }
    @Test
    public void addOneElementAndCheckSize() {
        // add element at the first index
        list.add(0,10);
        assertEquals(1,list.size());

    }

    @Test
    public void checkIfTheArrayListIsEmpty() {
        // add element at the first index
        list.add(0,10);
        assertFalse(list.isEmpty());
        // remove element at the first index
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void insertNewElementsInArrayList() {
        list.add(0,2);
        list.add(0,3);
        list.add(0,4);
        assertEquals(3,list.size());
        assertEquals((Integer) 4,list.get(0));
        assertEquals((Integer) 3,list.get(1));
        assertEquals((Integer) 2,list.get(2));
    }

    @Test
    public void replaceElementAtSpecificIndex() {
        list.add(0,10);
        list.add(1,20);
        list.add(2,30);
        assertEquals(3,list.size());
        int replaced = list.set(2,50);
        assertEquals(30,replaced);
        assertEquals((Integer) 50,list.get(2));
    }

    @Test
    public void removeElementAtSpecificIndex() {
        list.add(0,10);
        list.add(1,20);
        list.add(2,30);
        assertEquals(3,list.size());
        list.remove(1);
        list.remove(1);
        assertEquals(1,list.size());
        assertEquals((Integer) 10,list.get(0));

    }

    @Test
    public void getElementOutOfIndex() {
        assertThrows(IndexOutOfBoundsException.class,()->{
            list.get(1);
        });
    }

    @Test
    public void addElementOutOfTheIndexList() {
        list.add(0,10);
        assertThrows(IndexOutOfBoundsException.class,()->{
            list.add(3,30);
        });
    }
}