package algorithms;
/* 
@Author: mohammed.shalan 
@Date: 11-Jul-22
*/

import interfaces.Stack;
import stack.ArrayStack;

public class ReverseArrayUsingStack {

    public static <T> T[] reverse(T[] arr) {
        Stack<T> stack = new ArrayStack<>(arr.length);
        for (T t :
                arr) {
            stack.push(t);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }

}
