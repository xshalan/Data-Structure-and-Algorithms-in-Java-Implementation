package NodeBased;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/* 
@Author: mohammed.shalan 
@Date: 04-Aug-22
*/

public class NodeBasedListTest {
    private NodeBasedList<String> linkedList;
    @Before
    public void setUp() throws Exception {
        linkedList = new NodeBasedList<>();
    }
    @Test
    public void checkNumberOfElementsInList(){
        linkedList.addFirst("first");
        linkedList.addFirst("second");
        // second --> first
        int numOfElements = 2;
        assertEquals(numOfElements,linkedList.size());
    }

    @Test
    public void checkIfTheListIsEmpty(){
        int numOfElements = 0;
        // number of elements in list
        assertEquals(numOfElements,linkedList.size());
        // isEmpty, True if empty otherwise False
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void addElementsInTheList() {
        linkedList.addFirst("first");
        linkedList.addFirst("second");
        linkedList.addLast("third");
        // second --> first --> third
        assertEquals("second",linkedList.getFirst().element());
        assertEquals("third",linkedList.getLast().element());
        assertEquals("first",linkedList.getFirst().getNext().element());
        assertEquals("first",linkedList.getLast().getPrev().element());
    }

    @Test
    public void removeFirstElementFromTheList(){
        linkedList.addFirst("first");
        linkedList.addFirst("second");
        linkedList.addLast("third");
        // second --> first --> third
        int numOfElements = 3;
        assertEquals(numOfElements,linkedList.size());
        // return the deleted element
        assertEquals(linkedList.getFirst().element(),linkedList.remove(linkedList.getFirst()));
        numOfElements  = 2;
        assertEquals(numOfElements,linkedList.size());
        // check the first element after removal and the next element linked to it
        assertEquals("first",linkedList.getFirst().element());
        assertEquals("third",linkedList.getLast().element());
    }

    @Test
    public void addElementBeforeSpecificPosition(){
        linkedList.addFirst("first");
        linkedList.addFirst("second");
        linkedList.addLast("third");
        // second --> first --> third
        int numOfElements = 3;
        assertEquals(numOfElements,linkedList.size());

        linkedList.addBefore(linkedList.getFirst(), "at the first");
        numOfElements = 4;
        assertEquals(numOfElements,linkedList.size());
        assertEquals("at the first",linkedList.getFirst().element());
        assertEquals("second",linkedList.getFirst().getNext().element());
    }

    @Test
    public void addElementAfterSpecificPosition(){
        linkedList.addFirst("first");
        linkedList.addFirst("second");
        linkedList.addLast("third");
        // second --> first --> third
        int numOfElements = 3;
        assertEquals(numOfElements,linkedList.size());
        linkedList.addAfter(linkedList.getFirst(), "after the first");
        numOfElements = 4;
        assertEquals(numOfElements,linkedList.size());
        assertEquals("after the first",linkedList.getFirst().getNext().element());
        assertEquals("first",linkedList.getFirst().getNext().getNext().element());
    }
}