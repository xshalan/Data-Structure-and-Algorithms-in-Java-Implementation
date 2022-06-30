import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class SinglyLinkedListTest {
    SinglyLinkedList linkedList;

    @Before
    public void setUp() {
        linkedList = new SinglyLinkedList();
    }


    @Test
    public void addNewItemToFirstPlaceInLinkedList() {
        linkedList.addFirst("First Item");
        assertEquals(1,linkedList.size);
    }

    @Test
    public void insertAtTheHeadSinglyLinkedList() {
        linkedList.addFirst("First Item");
        linkedList.addFirst("second Item");
        assertEquals(2,linkedList.size);
        assertEquals("second Item",linkedList.head.getElement());
        assertEquals("First Item",linkedList.head.getNext().getElement());
        assertEquals(null,linkedList.head.getNext().getNext());
    }


    @Test
    public void insertTwoItemsAndCheckWhichOneIsTheTail(){
        linkedList.addFirst("First Item");
        linkedList.addFirst("Second Item");
        assertEquals("First Item",linkedList.tail.getElement());
        assertNotEquals("Second Item",linkedList.tail.getElement());
    }

    @Test
    public void insertItemAtTail(){
        linkedList.addFirst("First Item");
        linkedList.addFirst("Second Item");
        // [head] Second --> First --> Third [Tail]
        linkedList.addLast("Third Item");
        assertEquals(null,linkedList.tail.getNext());
        assertEquals("Third Item",linkedList.tail.getElement());
    }

    @Test
    public void removeFirstItem(){
        linkedList.addFirst("First Item");
        linkedList.addFirst("Second Item");
        // Seocnd --> First
        linkedList.removeFirst();
        assertEquals(1,linkedList.size);
        assertEquals("First Item",linkedList.head.getElement());
    }
}