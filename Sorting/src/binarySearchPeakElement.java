import java.util.*;
public class binarySearchPeakElement {
    public static void main(String[] args) {
        int[] arr={7,4,3,2,1};
        int ans;
            ans = searchPeak(arr);
            System.out.println(ans);
    }
    public static int searchPeak(int[] arr){
            int start=0;
            int end=arr.length-1;
            int ans=-1;
            while(start!=end) {
                int mid = start + (end - start) / 2;
                if(arr[mid]<arr[mid+1])start=mid+1;
                else if(arr[mid]>arr[mid+1])end=mid;
                if(start==end)return start;
                }
        return start;
    }

}

