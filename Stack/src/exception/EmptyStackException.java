package exception;/*
@Author: mohammed.shalan 
@Date: 08-Jul-22
*/
/**
 * Runtime Exception thrown when trying to pop an element from empty stack.
 * */
public class EmptyStackException extends RuntimeException{

    public EmptyStackException(String message) {
        super(message);
    }
}
