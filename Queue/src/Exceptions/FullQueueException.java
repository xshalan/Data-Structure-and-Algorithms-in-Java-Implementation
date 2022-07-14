package Exceptions;
/* 
@Author: mohammed.shalan 
@Date: 14-Jul-22
*/

public class FullQueueException extends RuntimeException{
    public FullQueueException(String message) {
        super(message);
    }
}
