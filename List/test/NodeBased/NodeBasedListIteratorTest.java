package NodeBased;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/* 
@Author: mohammed.shalan 
@Date: 04-Aug-22
*/

public class NodeBasedListIteratorTest {
    private NodeBasedList<String> linkedList;
    @Before
    public void setUp() throws Exception {
        linkedList = new NodeBasedList<>();

    }

    @Test
    public void printAllElementsViaIterator(){
        linkedList.addFirst("Hello");
        linkedList.addFirst("Lorem");
        linkedList.addFirst("World");
        Iterator<String> listIterator = linkedList.iterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
    }
}