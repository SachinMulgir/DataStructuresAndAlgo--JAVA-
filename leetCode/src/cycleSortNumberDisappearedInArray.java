import java.util.*;
//leetcode 448
//FIND ALL NUMBER DISAPPEARED IN ARRAY
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class cycleSortNumberDisappearedInArray {
    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};
        System.out.println(numberDisappeared(arr));
    }
    static List<Integer> numberDisappeared(int[] arr){
        ArrayList<Integer> list=new ArrayList<>();
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct])swap(arr,i,correct);
            else i++;
        }
        for(i=0;i<arr.length;i++){
            if(arr[i]!=i+1)list.add(i+1);
        }
        return list;
    }
    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
        return;
    }

}
