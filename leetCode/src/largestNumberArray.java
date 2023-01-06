import java.util.*;
//leetCode question: 179
//https://leetcode.com/problems/largest-number/
//5
//3 30 34 5 9
//output: 9534330 (combined largest number)

public class largestNumberArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        //solution
       for(int i=0;i<n-1;i++){
           for(int j=i+1;j<n;j++){
               String sum1=""+arr[i]+arr[j];
               String sum2=""+arr[j]+arr[i];
               if(sum1.compareTo(sum2)<0){
                   int temp=arr[j];
                   arr[j]=arr[i];
                   arr[i]=temp;
               }
           }
       }
       for(int i=0;i<n;i++){
           System.out.print(arr[i]);
       }
    }
}
