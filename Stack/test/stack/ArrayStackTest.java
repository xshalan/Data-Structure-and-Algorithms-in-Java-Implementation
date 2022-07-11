package stack;

import exception.EmptyStackException;
import interfaces.Stack;
import org.junit.Before;
import org.junit.Test;
import stack.ArrayStack;

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
    public void popUntilEmptyTheArray(){
        Integer[] arr = {1,2,3,4,5,6,7,8,9};
        Stack<Integer> stack = new ArrayStack<>(arr.length);
        for (int i = 0; i < arr.length ; i++) {
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(stack.pop());
        }
        assertEquals(0,stack.size());

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