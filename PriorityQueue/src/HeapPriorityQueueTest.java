import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/* 
@Author: mohammed.shalan 
@Date: 26-Aug-22
*/

public class HeapPriorityQueueTest {
    private HeapPriorityQueue<Integer,String> heap;
    @Before
    public void init(){
        heap = new HeapPriorityQueue<>();
    }
    @Test
    public void size() {
        heap.insert(1,"First Element!");
        assertEquals(1,heap.size());
    }

    @Test
    public void insertNewElements_ReturnMinimum() {
        heap.insert(3,"Third Element!");
        heap.insert(2,"Second Element!");
        heap.insert(0,"Zero Element!");
        heap.insert(1,"First Element!");
        assertEquals(0,(int)heap.min().getKey());
    }

    @Test
    public void insertNewElements_ReturnMinimumAndRemoveIt() {
        heap.insert(3,"Third Element!");
        heap.insert(2,"Second Element!");
        heap.insert(0,"Zero Element!");
        heap.insert(1,"First Element!");
        assertEquals(0,(int)heap.removeMin().getKey());
        assertEquals(1,(int)heap.removeMin().getKey());
        assertEquals(2,(int)heap.removeMin().getKey());
        assertEquals(1,heap.size());
    }

}