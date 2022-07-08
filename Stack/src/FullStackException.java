/*
@Author: mohammed.shalan 
@Date: 08-Jul-22
*/
/**
 * Runtime Exception thrown when trying to push an element on array-based stack that have no empty index.
 *
 * */
public class FullStackException extends RuntimeException{

    public FullStackException(String message) {
        super(message);
    }
}
