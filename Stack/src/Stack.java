/*
@Author: mohammed.shalan 
@Date: 08-Jul-22
*/
/**
 * Abstract data type(interface) to define the common methods
 * */
public interface Stack<T> {

    void push(T object) throws FullStackException;
    T pop() throws EmptyStackException;
    T top() throws EmptyStackException;
    int size() ;
    boolean isEmpty();

}
