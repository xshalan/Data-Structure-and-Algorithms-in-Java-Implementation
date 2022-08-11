package exceptions;
/* 
@Author: mohammed.shalan 
@Date: 10-Aug-22
*/

public class InvalidPositionException extends RuntimeException{

    public InvalidPositionException(String message) {
        super(message);
    }
}
