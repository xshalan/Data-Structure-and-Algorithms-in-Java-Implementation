public class InsertionSort {

    private int[] arr;

    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    public int[] sort(){
        for(int i=1;i<arr.length;i++){
            int cur = arr[i];
            int j = i-1 ;
            while(j>=0 && arr[j]>cur){
                arr[j+1] = arr[j];
                arr[j] = cur;
                j--;

            }
        }
        return arr;
    }


}
