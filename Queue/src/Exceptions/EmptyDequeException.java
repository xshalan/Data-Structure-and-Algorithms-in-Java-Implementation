package Exceptions;
/* 
@Author: mohammed.shalan 
@Date: 18-Jul-22
*/

public class EmptyDequeException extends RuntimeException{
    public EmptyDequeException(String message) {
        super(message);
    }
}
