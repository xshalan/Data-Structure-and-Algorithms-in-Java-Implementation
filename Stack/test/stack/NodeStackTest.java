package stack;

import interfaces.Stack;
import org.junit.Before;
import org.junit.Test;
import stack.NodeStack;

import static org.junit.Assert.*;

/* 
@Author: mohammed.shalan 
@Date: 08-Jul-22
*/

public class NodeStackTest {
    Stack<String> stack;

    @Before
    public void setup() {
        stack = new NodeStack<>();
    }
    @Test
    public void checkTheTopElementAfterPush() {
        stack.push("A");
        stack.push("C");
        stack.push("Hello");
        assertEquals("Hello",stack.top());
    }

    @Test
    public void popTheTopElement() {
        stack.push("A");
        stack.push("C");
        stack.push("Hello");

        String removed = stack.pop();
        assertEquals("Hello",removed);
        assertEquals(2,stack.size());
    }

    @Test
    public void checkTheTopElement() {
        stack.push("A");
        stack.push("C");
        stack.push("Hello");
        assertEquals("Hello",stack.top());
    }

    @Test
    public void checkTheStackSize() {
        stack.push("A");
        stack.push("C");
        stack.push("Hello");
        assertEquals(3,stack.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(stack.isEmpty());
    }
}