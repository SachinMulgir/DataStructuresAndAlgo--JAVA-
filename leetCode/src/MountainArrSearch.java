//leetcode 1095
//https://leetcode.com/problems/find-in-mountain-array/
//find element in mountain array: return index of 1st occurrence.
public class MountainArrSearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,5,4,3,1};
        int target=4;
        int ans=findInMountainArray(target,arr);
        System.out.println(ans);
    }
    public static int findInMountainArray(int target, int[] mountainArr) {
        int peak=peakElement(mountainArr,target);
        int ans=-1;
        ans=binarySearch(mountainArr,0,peak,target);
        if(ans==-1){
            ans=binarySearch(mountainArr,peak,mountainArr.length-1,target);
        }
        return ans;
    }
    public static int peakElement(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]<arr[mid+1])start=mid+1;
            if(arr[mid]>arr[mid+1])end=mid;
            if(start==end)return start;
        }
        return start;
    }
    public static int binarySearch(int[] arr,int start,int end,int target){
        boolean isAsc=arr[start]<arr[end];
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                ans=mid;
                break;
            }
            if(isAsc){
                if(arr[mid]>target)end=mid-1;
                else start=mid+1;
            }else{
                if(arr[mid]>target)start=mid+1;
                else end=mid-1;
            }
        }
        return ans;
    }
}
