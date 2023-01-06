//MISSING NUMBER
//LEETCODE 268
//https://leetcode.com/problems/missing-number/

public class cycleSortMissingNumber {
    public static void main(String[] args) {
        int[] arr={0,1,4,3};
        System.out.println(missingNumber(arr));

    }
    static int missingNumber(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i];
            if(correct<arr.length && arr[i]!=arr[correct])swap(arr,i,correct);
            else i++;
        }
        for(i=0;i<arr.length;i++){
            if(arr[i]!=i)return i;
        }
        return arr.length;
    }
    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
        return;
    }
}
