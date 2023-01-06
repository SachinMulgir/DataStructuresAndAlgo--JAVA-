import java.util.Scanner;

public class binarySearchAlgorithm {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int target=sc.nextInt();
            int ans=binarySearch(arr,target);
            System.out.println("element is found at index: "+ans);
        }
    static int binarySearch(int[] arr,int target){
            int start=0;
            int end=arr.length-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(target<arr[mid]){
                    end=mid-1;
                }else if(target>arr[mid]){
                    start=mid+1;
                }else if(target==arr[mid]){
                    return mid;                          //returns the index if the element is found.
                }
            }
            return -1;
    }
}


