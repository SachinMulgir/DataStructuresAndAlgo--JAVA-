import java.util.*;
public class binarySearchSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] arr={'c','f','j'};
        char target='j';
        char ans=smallestGreaterChar(arr,target);
        System.out.println(ans);
    }
    public static char smallestGreaterChar(char[] arr,char target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>target)end=mid-1;
            else if(arr[mid]<target)start=mid+1;
            else{
                start=mid+1;
            }
        }
        return arr[start%arr.length];
    }
}
