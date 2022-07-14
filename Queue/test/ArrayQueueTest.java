import Interfaces.Queue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/* 
@Author: mohammed.shalan 
@Date: 14-Jul-22
*/

public class ArrayQueueTest {
    private Queue<String> queue;
    @Before
    public void setUp() throws Exception {
            queue = new ArrayQueue<>();
    }

    @Test
    public void addElementsToQueueAndCheckSize() {
        queue.enqueue("Hello");
        queue.enqueue("World");
        assertEquals(2,queue.size());
    }

    @Test
    public void checkIfTheQueueIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void getTheFirstElementAddedToQueue_Front() {
        queue.enqueue("Hello");
        queue.enqueue("World");
        assertEquals("Hello",queue.getFront());
    }


    @Test
    public void dequeueElementFromQueue() {
        queue.enqueue("Hello");
        queue.enqueue("World");
        assertEquals("Hello",queue.dequeue());
        assertEquals(1,queue.size()); // Check size after dequeue an element
    }
}