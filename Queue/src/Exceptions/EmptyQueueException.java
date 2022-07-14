package Exceptions;
/* 
@Author: mohammed.shalan 
@Date: 14-Jul-22
*/

public class EmptyQueueException extends RuntimeException{
    public EmptyQueueException(String message) {
        super(message);
    }
}
