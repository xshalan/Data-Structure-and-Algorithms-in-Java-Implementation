import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecursionTest {
    private int[] arr ;
    private Recursion recursion;
    @Before
    public void setup(){
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        recursion = new Recursion();
    }
    @Test
    public void reverseArrayWithTail() {
        int[] reversedArr  = {9,8,7,6,5,4,3,2,1};
        assertArrayEquals(reversedArr,recursion.reverseArrayWithTail(arr,0,arr.length-1));
    }

    @Test
    public void sumArrayWithTail() {
        assertEquals(45,recursion.sumArrayWithTail(arr, arr.length, 0));
    }

    @Test
    public void sumArray() {
        assertEquals(45,recursion.sumArray(arr, arr.length));
    }
}