import java.util.*;
public class quickSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr = {9,6,85,4,54,1};
        quickSortAlgo(0,arr.length-1,arr);       //function call for quickSortAlgo
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSortAlgo(int start,int end,int[] arr){
        if(start >= end){                               //break condition
            return;
        }
        int indexPivot = findPivot(start,end,arr);      //function call to find the pivot element
        //recursive case
        quickSortAlgo(start,indexPivot-1,arr);    //for LHS: with each call start and end are updating
        quickSortAlgo(indexPivot+1,end,arr);      //for RHS: with each call start and end are updating
    }
    public static int findPivot(int start,int end, int[] arr){
        int pivot = arr[end];
        int i = start;
        for(int j = start;j < end; j++){
            if(arr[j] < pivot){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[end];
        arr[end] = arr[i];
        arr[i] = temp;

        return i;                           //return index of pivot for seperating LHS and RHS.
    }
}
