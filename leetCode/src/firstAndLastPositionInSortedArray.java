import java.util.*;
public class firstAndLastPositionInSortedArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,7,7,7,7,10,14,12};
        int target=7;
        int[] ans=searchRange(arr,target);
        System.out.println(Arrays.toString(ans));
    }
    //try to create a function for binary search both first and last by using conditions.
    //write DRY code.
    public static int[] searchRange(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int first=-1;
        int last=-1;
        //for the first occurence of the target
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>target)end=mid-1;
            else if(nums[mid]<target)start=mid+1;
            else{
                first=mid;
                end=mid-1;
            }
        }
        start=0;
        end=nums.length-1;
        //for the last occurence of the target
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>target)end=mid-1;
            else if(nums[mid]<target)start=mid+1;
            else{
                last=mid;
                start=mid+1;
            }
        }
        return new int[]{first,last};
    }
}
