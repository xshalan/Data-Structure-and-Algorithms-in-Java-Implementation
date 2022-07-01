import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    private DoublyLinkedList linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new DoublyLinkedList();
    }

    @Test
    public void insertItemAtHeadPlace() {
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        // [head] -> <= B => <= A => [tail]
        assertEquals("B", linkedList.head.getNext().getElement());
        assertEquals("A", linkedList.head.getNext().getNext().getElement());
        assertEquals(2, linkedList.size);
    }

    @Test
    public void insertItemAfterSpecificNode() {
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addFirst("C");
        // [head] -> <= C => <= B => <= A => [tail]
        // add item after node "B"
        // [head] -> <= C => <= B => <= D => <= A => [tail]
        linkedList.addAfter("D", linkedList.head.getNext().getNext());
        assertEquals("D", linkedList.head.getNext().getNext().getNext().getElement());
        assertEquals("B", linkedList.head.getNext().getNext().getNext().getPrev().getElement());
        assertEquals("A", linkedList.head.getNext().getNext().getNext().getNext().getElement());
        assertEquals(4, linkedList.size);
    }

    @Test
    public void getPreviousNodeForSpecificNode() {
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addFirst("C");
        // [head] -> <= C => <= B => <= A => [tail]
        assertEquals("C", (linkedList.getPrev(linkedList.head.getNext().getNext()).getElement()));
    }

    @Test
    public void throwErrorWhenGetPrevNodeAtHead() {
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addFirst("C");
        // [head] -> <= C => <= B => <= A => [tail]
        assertThrows(IllegalArgumentException.class, () -> {
            linkedList.getPrev(linkedList.head);
        });
    }

    @Test
    public void throwErrorWhenGetNextNodeAtTail() {
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addFirst("C");
        // [head] -> <= C => <= B => <= A => [tail]
        assertThrows(IllegalArgumentException.class, () -> {
            linkedList.getNext(linkedList.tail);
        });
    }

    @Test
    public void removeNodeFromTheList() {
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addFirst("C");
        // [head] -> <= C => <= B => <= A => [tail]
        linkedList.remove(linkedList.head.getNext());
        assertEquals("B", linkedList.head.getNext().getElement());
        linkedList.remove(linkedList.head.getNext());
        assertEquals("A", linkedList.head.getNext().getElement());
        assertEquals(1, linkedList.size);
    }

}