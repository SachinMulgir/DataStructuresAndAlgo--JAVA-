import java.util.Arrays;
//ONLY WORKS ON THE ARRAYS WITH NUMBERS 1 TO N. IN A SEQUENCE. NOT FOR RANDOM NUMBER ARRAYS.
public class cycleSortAlgorithm {
    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cycleSort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct])swap(arr,i,correct);
            else i++;
        }
    }
    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
