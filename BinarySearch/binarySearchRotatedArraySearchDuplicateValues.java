import java.util.*;
//target given in rotated sorted array, we've to find the target element from the array. less time complexity
public class binarySearchRotatedArraySearchDuplicateValues {
    public static void main(String[] args) {
        int[] arr={3,4,5,6,7,0,1,2};
        int target=5;
        int pivot=findPivot(arr);
        System.out.println(pivot);
        int ans=search(arr,target,pivot);
    }
    static int findPivot(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1])return mid;
            else if(mid>start && arr[mid]<arr[mid-1])return mid-1;
            else if(arr[mid]==arr[start] && arr[mid]==arr[end]){
                if(arr[start]>arr[start+1])return start;
                start++;
                if(arr[end]<arr[end-1])return end-1;
                end--;
            }
            else{
                if(arr[start]<arr[mid] || (arr[start]==arr[mid] && arr[mid]>arr[end]))start=mid+1;
                else end=end-1;
            }
        }
        return -1;
    }
    static int search(int[] arr,int target, int pivot){
        if(pivot==-1)return binarySearch(arr,target,0,arr.length-1);
        if(target>=arr[0])return  binarySearch(arr,target,0,pivot-1);
        if(target<arr[0])return binarySearch(arr,target,pivot+1,arr.length-1);
        return binarySearch(arr,target,0,arr.length-1);
    }
    static int binarySearch(int[] arr,int target, int start,int end){
            while(start<=end){
                int mid=start+(end-start)/2;
                if(arr[mid]>target)end=mid-1;
                else if(arr[mid]<target)start=mid+1;
                else return mid;
            }
            return -1;
    }
}
