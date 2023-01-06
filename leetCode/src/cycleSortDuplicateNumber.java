import java.util.*;
//leetcode 287 (asked in amazon and microsoft)
//FIND THE DUPLICATE NUMBER;
//https://leetcode.com/problems/find-the-duplicate-number/
public class cycleSortDuplicateNumber {
    public static void main(String[] args) {
        int[] arr={3,1,6,4,5,4};
        int ans=duplicateNumber(arr);
        System.out.println(ans);
    }
    static int duplicateNumber(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(correct<arr.length && arr[correct]!=arr[i])swap(arr,correct,i);
            else i++;
        }
        for(i=0;i<arr.length;i++){
            if(arr[i]!=i+1)return arr[i];
        }
        return -1;
    }
    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
