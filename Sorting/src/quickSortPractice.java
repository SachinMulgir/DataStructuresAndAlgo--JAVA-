import java.util.*;
public class quickSortPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort( int[] arr, int start, int end){
        if( start >= end ){
            return;
        }
        int pivotIdx = findPivot( arr, start, end );

        quickSort( arr, start, pivotIdx - 1);
        quickSort( arr, pivotIdx + 1, end );

    }
    public static int findPivot(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if( arr[j] < pivot ){
                swap( arr, i , j);
                i++;
            }
        }
        swap( arr, i , end);
        return i;
    }
    public static void swap( int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
