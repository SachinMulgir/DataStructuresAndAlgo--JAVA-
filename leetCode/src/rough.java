import java.util.*;
public class rough {
    public static void main(String[] args) {
        int[] arr={8,7,4,5,6,2,4,1,2,0};
       // System.out.println("bubble sort:");
       // bubbleSort(arr);
       // System.out.println("Selection sort");
       // selectionSort(arr);
//        System.out.println("insertion sort");
//        insertionSort(arr);
        System.out.println("Cycle Sort:");
        int[] cycleArr={3,4,5,2,1};
        cycleSort(cycleArr);
        System.out.println(Arrays.toString(cycleArr));
    }
    //BUBBLE SORT:
    //it compares two consecutive values and put the smaller value in front(lhs).
    //in each iteration the largest values goes to the end of the array.
    //when it is not swapping we can break the loop. since every element rhs of it will be greater than itself
    public static void bubbleSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            boolean swap=false;
            for(int j=1;j<n-i;j++){
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
    //SELECTION SORT:
    //it selects the maximum element and pushes it at the end...in each iteration it searches from 0 to n-i-1 length.
    //find max...swap with last element.
    //if no swap occurs exit the loop.(will save time by not wasting on unwanted comparisons)
    public static void selectionSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=0;j<n-i;j++){
                if(arr[j]>arr[max])max=j;
            }
            if(max==n-i-1)break;
            int temp=arr[max];
            arr[max]=arr[n-i-1];
            arr[n-i-1]=temp;
            System.out.println(Arrays.toString(arr));
        }
    }
    //INSERTION SORT:
    //start comparing from first two elements...in each iteration the range increases.
    //as we move forward...the smaller elements are swapped towards the start.
    //if no swap occurs break the inner loop. move forward
    public static void insertionSort(int[] arr){
        int n=arr.length;
        int i=0;
        while(i<n-1){
            for(int j=i+1;j>0;j--){
                if(arr[j]<=arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                else break;
            }
            System.out.println(Arrays.toString(arr));
            i++;
        }
    }
    //CYCLE SORT:
    //it is used only in the cases when range is given.(1 to N) or (0 to N);
    //match index with elements to get the answer.
    //NOTE> when given (0 to N). index=value. when given (1 to N)-> index=value-1;
    public static void cycleSort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;              //for the range 1 to N.
            if(arr[correct]!=arr[i]){
                int temp=arr[i];
                arr[i]=arr[correct];
                arr[correct]=temp;
            }
            else{
                i++;
            }

        }
    }
}
