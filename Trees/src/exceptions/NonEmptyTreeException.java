package exceptions;
/* 
@Author: mohammed.shalan 
@Date: 10-Aug-22
*/

public class NonEmptyTreeException extends RuntimeException {
    public NonEmptyTreeException(String message) {
        super(message);
    }
}
