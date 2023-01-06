import java.util.*;
//
public class binarySearchRotatedArrayRotationCount {
    public static void main(String[] args) {
        int[] arr={12,12,13,13,0,1,2,3,4,5,8};
        int pivot=findPivot(arr);
        if(pivot==-1) System.out.println(0);
        else System.out.println(pivot+1);
    }
    static int findPivot(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1])return mid;
            if(mid>start && arr[mid]<arr[mid-1])return mid-1;
            if(arr[mid]==arr[start] && arr[mid]==arr[end]){
                if(arr[start]>arr[start+1])return start;
                else if(arr[end]<arr[end-1])return end-1;
                start++;
                end--;
            }else{
                if(arr[start]<arr[mid] || (arr[start]==arr[mid] && arr[mid]>arr[end])){
                    start=mid+1;
                }else end=mid-1;
            }
        }
        return -1;

    }
}
