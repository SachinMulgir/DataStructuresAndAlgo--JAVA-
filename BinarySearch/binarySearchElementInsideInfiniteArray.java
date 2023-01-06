import java.util.*;
public class binarySearchElementInsideInfiniteArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,6,9,11,13,14,15,18,20,21,23,25};
        int target=14;
        int ans=rangeOfSearch(arr,target);
        System.out.println(ans);
    }
    public static int rangeOfSearch(int[] arr,int target){
        int start=0;
        int end=1;
        while(arr[end]<target){
            int temp=end+1;
            end=end+(end-start+1)*2;
            start=temp;
        }

        int ans=search(arr,target,start,end);
        return ans;
    }
    public static int search(int[] arr,int target,int start,int end){
        int ans=-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>target)end=mid-1;
            else if(arr[mid]<target)start=mid+1;
            else if(arr[mid]==target){
                ans=mid;
                return ans;
            }
        }

        return ans;
    }
}
