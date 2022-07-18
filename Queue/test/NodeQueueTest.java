import Interfaces.Queue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/* 
@Author: mohammed.shalan 
@Date: 18-Jul-22
*/

public class NodeQueueTest {

    Queue<String> nodeQueue;
    @Before
    public void setup(){
        nodeQueue = new ArrayQueue<>();
        nodeQueue.enqueue("Hello");
        nodeQueue.enqueue("World");
    }

    @Test
    public void checkQueueSizeAfterEnqueueElements() {

        assertEquals(2,nodeQueue.size());
    }

    @Test
    public void checkIfQueueIsEmpty() {
        nodeQueue.dequeue();
        nodeQueue.dequeue();
        assertEquals(0,nodeQueue.size());
    }

    @Test
    public void getTheFirstElementInQueue() {
        assertEquals("Hello",nodeQueue.getFront());
    }

    @Test
    public void addElementToQueue() {
        nodeQueue.enqueue("New Element");
        assertEquals(3,nodeQueue.size());
    }

    @Test
    public void removeElementFromQueue() {
        String removed = nodeQueue.dequeue();
        assertEquals("Hello",removed);
    }
}