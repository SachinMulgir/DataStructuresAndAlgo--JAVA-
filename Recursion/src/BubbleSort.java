import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 4,2,1,3 };
        bubbleSort(arr, arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr, int row, int col){
        if( row == 0 ){
            return;
        }
        if( col < row ){
            if( arr[col] > arr[col + 1]){
                //swap
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubbleSort(arr,row,col+1);               // for comparing the current with all other( col++ )
        }else{
            bubbleSort(arr,row-1,0);            // for changing the current element (row++ & col=0)
        }
    }
}
