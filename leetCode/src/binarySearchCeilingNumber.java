import java.util.*;
//ceiling number: the smallest number that is greater than or equal to the target element;
public class binarySearchCeilingNumber {
    public static void main(String[] args) {
        //sorted array
        int[] arr={2,3,5,9,14,16,18};
        int target=15;
        int ans=ceilingNumber(arr,target);
        System.out.println(ans);
    }
    static int ceilingNumber(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        boolean isAsc=arr[start]<arr[end];
        int min=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+(end-start)/2;
//            if(arr[mid]>=target && arr[mid]<min)min=arr[mid];
            if(isAsc){
                if(arr[mid]<target){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }else{
                if(arr[mid]<target){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return arr[start];
    }
}
