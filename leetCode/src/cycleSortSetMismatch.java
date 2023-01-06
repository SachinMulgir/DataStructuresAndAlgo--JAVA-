import java.util.*;
//leetcode 645
//https://leetcode.com/problems/set-mismatch/submissions/
//SET MISMATCH: ONE ELEMENT IS REPLACED WITH SOME ELEMENT. ARRAY GETS DUPLICATE NUMBER AND A MISSING NUMBER
//FIND BOTH NUMBERS
public class cycleSortSetMismatch {
    public static void main(String[] args) {
        int[] arr={1,2,2,4,5};
        int[] ans=findErrorNums(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int[] findErrorNums(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct=nums[i]-1;
            if(correct<nums.length && nums[correct]!=nums[i])swap(nums,i,correct);
            else i++;
        }
        for(i=0;i<=nums.length;i++){
            if(nums[i]!=i+1)return new int[]{nums[i],i+1};
        }
        return new int[]{-1,-1};
    }
    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
        return;
    }
}
