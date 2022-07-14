package algorithms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/* 
@Author: mohammed.shalan 
@Date: 11-Jul-22
*/

public class ReverseArrayUsingStackTest {

    @Test
    public void reverseArrayUsingStack(){
        Integer[] arr = {1,2,3,4,5,6,7,8,9};
        Integer[] reversed_arr = {9,8,7,6,5,4,3,2,1};
        assertArrayEquals(reversed_arr,ReverseArrayUsingStack.reverse(arr));
    }
}