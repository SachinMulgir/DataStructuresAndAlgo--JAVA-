import java.util.*;
//AccioJob concept.
public class mergeSort {
    public static void main(String[] args) {
        int[] arr={5,1,2,3,4,2};
        int start=0;
        int end=arr.length-1;
        mergeSort(arr,start,end);
        System.out.println(Arrays.toString(arr));

    }
    //Division function for the mergeSort.
    public static void mergeSort(int[] arr,int start,int end){
        //base case
        if(start==end){
            return;
        }
        //recursive case
        int mid=start+(end-start)/2;
        mergeSort(arr,start,mid);            //will run recursively till the base case is reached.
        mergeSort(arr,mid+1,end);
        //Calling merge() function once the elements are divided up to the last single element
        merge(arr,start,end,mid);

    }
    //Combining function for the mergeSort.
    public static void merge(int[] arr,int start,int end,int mid){
        //Part 1: first half of the array(start --> mid)
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=start;i<=mid;i++){
            A.add(arr[i]);
        }
        //Part 2: second half of the array(mid+1 --> end)
        ArrayList<Integer> B=new ArrayList<>();
        for(int i=mid+1;i<=end;i++){
            B.add(arr[i]);
        }
        //Part 3: Combine Part1 and Part2
        ArrayList<Integer> C=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<A.size() && j<B.size()){
            if(A.get(i)<= B.get(j)){
                C.add(A.get(i));
                i++;
            }
            else{
                C.add(B.get(j));
                j++;
            }
        }
        //code to add remaining elements of either i or j
        while(i<A.size()){
            C.add(A.get(i));
            i++;
        }
        while(j<B.size()){
            C.add(B.get(j));
            j++;
        }
        //Part 4: Update the original array
        for(int k=0;k<C.size();k++){
            arr[start+k]=C.get(k);
        }
    }
}
