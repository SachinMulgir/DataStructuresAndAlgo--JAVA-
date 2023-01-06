import java.util.Arrays;

public class insertionSortAlgorithm {
    public static void main(String[] args) {
        int[] arr={-4,5,8,-1,0,3,15,78,-65,-985,14};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1])swap(arr,j,j-1);
                else break;
            }
        }
    }
    static void swap(int[] arr, int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
