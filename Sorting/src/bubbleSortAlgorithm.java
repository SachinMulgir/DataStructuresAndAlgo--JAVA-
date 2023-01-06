import java.util.*;
public class bubbleSortAlgorithm {
    public static void main(String[] args) {
        int[] arr={-9,7,5,6,1,-8,9,65,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            boolean swap=false;
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swap=true;
                }
            }
            if(swap==false)break;
        }
    }
}
