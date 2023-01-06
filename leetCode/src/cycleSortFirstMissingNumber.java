import java.util.*;
//leetcode 41(hard)
//FIRST MISSING POSITIVE INTEGER:we know +ve int. start from 1 to n; therefore arr needs to be like[1,2,3..n];
//therefore we apply cycle sort
//https://leetcode.com/problems/first-missing-positive/


public class cycleSortFirstMissingNumber {
    public static void main(String[] args) {
        int[] arr={3,4,-1,1};
        System.out.println(firstMissingInteger(arr));
    }
    static int firstMissingInteger(int[] arr){
        int i=0;
        while(i<arr.length){
            if(arr[i]>0){
                int correct=arr[i]-1;
                if(correct<arr.length && arr[i]!=arr[correct])swap(arr,i,correct);
                else i++;
            }
            else i++;
        }
        for(i=0;i<arr.length;i++){
            if(arr[i]!=i+1)return i+1;
        }
        return i+1;
    }
    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
