import java.util.*;
public class recursionBinarySearch {
    public static void main(String[] args) {
        int[] arr={1,2,5,34,45,64,75,76,87,97};
        int target=43;
        int ans=search(arr,target,0,arr.length-1);
        System.out.println(ans);
    }
    public static int search(int[] arr,int target,int start,int end){
        //base condition: where the recursion will break
        if(start>end)return -1;

        //find the middle index:
        int mid=start+(end-start)/2;

        //the basic three comparisons of the binary search
        if(arr[mid]==target)return mid;
        if(arr[mid]<target)start=mid+1;
        else end=mid-1;

        //recursion call: with updated value of start and end.
        return search(arr,target,start,end);
    }
}
//start and end are used as arguments in the function because they'll help us reduce the array to half in
//each iteration. Therefore we'll pass 'start' and 'end' as the arguments.(while updating them inside the body)

//'mid' is not passed as argument because it is particularly dedicated to that particular function call...and
//with each call we're changing it using updated value of 'start' and 'end'.
