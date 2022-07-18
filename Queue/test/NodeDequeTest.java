import Interfaces.Deque;
import org.junit.Test;

import static org.junit.Assert.*;

/* 
@Author: mohammed.shalan 
@Date: 18-Jul-22
*/

public class NodeDequeTest {

    @Test
    public void addElementToTheFirst(){
        Deque<Integer> integerDeque  = new NodeDeque<>();
        integerDeque.addFirst(1);
        integerDeque.addFirst(2);
        integerDeque.addFirst(3);
        integerDeque.addFirst(4);
        System.out.println(integerDeque.getFirst());
        System.out.println(integerDeque.getLast());
        assertEquals(4,(int) integerDeque.getFirst());
        assertEquals(1,(int) integerDeque.getLast());
    }

    @Test
    public void addElementToTheLast(){
        Deque<Integer> integerDeque  = new NodeDeque<>();
        integerDeque.addLast(1);
        integerDeque.addLast(2);
        integerDeque.addLast(3);
        integerDeque.addLast(4);
        System.out.println(integerDeque.getFirst());
        System.out.println(integerDeque.getLast());
        assertEquals(1,(int) integerDeque.getFirst());
        assertEquals(4,(int) integerDeque.getLast());
    }

    @Test
    public void removeElementFromTheLast(){
        Deque<Integer> integerDeque  = new NodeDeque<>();
        integerDeque.addLast(1);
        integerDeque.addLast(2);
        integerDeque.addLast(3);
        integerDeque.addLast(4);
        System.out.println(integerDeque.removeLast());

        assertEquals(1,(int) integerDeque.getFirst());
        assertEquals(3,(int) integerDeque.getLast());
    }


    @Test
    public void removeElementFromTheFirst(){
        Deque<Integer> integerDeque  = new NodeDeque<>();
        integerDeque.addFirst(1);
        integerDeque.addFirst(2);
        integerDeque.addLast(3);
        integerDeque.addLast(4);
        integerDeque.addLast(5);
        // 2 -> 1 -> 3 -> 4 -> 5
        System.out.println(integerDeque);
        System.out.println(integerDeque.removeLast()); // 5
        System.out.println(integerDeque.removeFirst()); // 2
        System.out.println(integerDeque);
        assertEquals(1,(int)integerDeque.getFirst());
        assertEquals(4,(int)integerDeque.getLast());

    }


}