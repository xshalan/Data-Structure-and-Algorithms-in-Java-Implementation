import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InsertionSortTest {
    public InsertionSort insertionSort;

    @Before
    public void setUp() {
       int[] arr = {10,20,50,5,15,90,70,100};
        insertionSort = new InsertionSort(arr);
    }

    @Test
    public void testInsertionSort(){
        int[] sortedList = {5,10,15,20,50,70,90,100};
        Assert.assertArrayEquals(sortedList, insertionSort.sort());
    }
}