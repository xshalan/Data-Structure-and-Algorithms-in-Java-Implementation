import java.util.Arrays;

public class Recursion {

    // Sum the elements of the array.
    // Base case: first element > last element
    // Repeat process: swap the first element with the last element.
    public int[] reverseArrayWithTail(int[] arr, int first, int last) {
        if(first<last){
            int tempFirst = arr[first];
            arr[first] = arr[last];
            arr[last] =  tempFirst;
            reverseArrayWithTail(arr,first+1,last-1);
        }
        return arr;
    }


    // Sum the elements of the array.
    // Base case: size of array = 0 then sum is equal the sum flag which initialize with zero 0.
    // Repeat process: add sum to the last element and decrease the length by 1 .
    public int sumArrayWithTail(int[] arr, int length, int sum) {
        if (length == 0)
            return sum;

        return sumArrayWithTail(arr, length - 1, sum + arr[length - 1]);

    }

    // Sum the elements of the array.
    // Base case: size of array = 1 then sum is equal the first element.
    // Repeat process: last element + array minus that element.
    public int    sumArray(int[] arr, int length) {
        if (length == 1)
            return arr[0];
        else
            return sumArray(arr, length - 1) + arr[length - 1];
    }


}
