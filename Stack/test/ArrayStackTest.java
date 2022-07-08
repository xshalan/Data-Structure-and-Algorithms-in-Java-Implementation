import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/* 
@Author: mohammed.shalan 
@Date: 08-Jul-22
*/

public class ArrayStackTest {
    Stack<String> stack;

    @Before
    public void setup() {
        stack = new ArrayStack<>();
    }

    @Test
    public void pushStringToStack() {
        stack.push("A");

        assertEquals("A", stack.top());
    }

    @Test
    public void popStringFromStack() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.pop();
        assertEquals("B",stack.top());
    }

    @Test
    public void getTheFirstElement() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("C",stack.top());
    }

    @Test(expected = EmptyStackException.class)
    public void getTheFirstElementEmptyStack_ThrowException() {
        stack.pop();

    }

    @Test
    public void getSizeOfStack() {
        stack.push("A");
        stack.push("A");
        stack.push("A");
        assertEquals(3,stack.size());

    }

    @Test
    public void checkIfStackIsEmpty() {
        assertTrue(stack.isEmpty());
    }
}