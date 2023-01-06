import java.util.*;

public class MergeSortAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int start = 0;
        int end = arr.length - 1;
        mergeSortAlgo(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSortAlgo(int[] arr, int start, int end){
        if( start == end ){
            return;
        }
        int mid = start + (end - start) / 2;

        mergeSortAlgo( arr, start, mid);
        mergeSortAlgo( arr, mid + 1, end);

        mergeArr( arr, start, mid, end );
    }
    public static void mergeArr( int[] arr, int start, int mid, int end ){
        //we've got the whole array here.
        //first we need to create two sub arrays using: start / mid / end
        //we'll get different values of start mid and end each time/ according to those we'll merge

        // left half of the array:
        ArrayList<Integer> left = new ArrayList<>();
        for( int i = start ; i <= mid ; i++ ){
            left.add(arr[i]);
        }

        //right half of the array:
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = mid + 1; i <= end; i++) {
            right.add(arr[i]);
        }

        //merge both the lists:
        //create new answer list to store the value
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while( i < left.size() && j < right.size() ){
            if( left.get(i) <= right.get(j) ){
                ans.add( left.get(i) );
                i++;
            }else{
                ans.add( right.get(j) );
                j++;
            }
        }

        //will run if left has bigger size and has leftover elements to add
        while( i < left.size() ){
            ans.add( left.get(i) );
            i++;
        }
        //will run if right has bigger size and has leftover elements to add
        while( j < right.size() ){
            ans.add( right.get(j) );
            j++;
        }

        //update the original array:
        for (int k = 0; k < ans.size(); k++) {
            arr[start + k] = ans.get(k);
        }
    }
}
