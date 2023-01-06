//https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
//leetcode link
public class binarySearchRotatedArraySearch {
    public static void main(String[] args) {
        int[] arr={6,7,1,2,3,4,5};
        int target=6;
        int pivot=findPivot(arr);
        int ans=search(arr,target,pivot);
        System.out.println(ans);
    }
    static int findPivot(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if( mid<end && arr[mid]>arr[mid+1])return mid;
            else if(mid>start && arr[mid]<arr[mid-1])return mid-1;
            else if(mid>start && arr[start]>=arr[mid])end=mid-1;
            else start=mid+1;
        }
        return -1;
    }
    static int search(int[] arr,int target,int pivot){
        if(pivot==-1){
           return binarySearch(arr,target,0,arr.length-1);
        }
        if(arr[pivot]==target)return pivot;
        else if(target>=arr[0])return binarySearch(arr,target,0,pivot-1);
        else if(target<arr[0])return binarySearch(arr,target,pivot+1,arr.length-1);
        return -1;
    }
    static int binarySearch(int[] arr,int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }else if(target>arr[mid]){
                start=mid+1;
            }else if(target==arr[mid]){
                return mid;                          //returns the index if the element is found.
            }
        }
        return -1;
    }
}
