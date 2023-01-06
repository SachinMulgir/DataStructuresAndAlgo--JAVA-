public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={2,3,5,6,7,9,10,15};
        int target=10;
        System.out.println(binarySearch(arr,target,0,arr.length-1));
    }
    public static int binarySearch(int[]arr,int target,int start,int end){
        if(start>end)return -1;
        int mid=start+(end-start)/2;
        if(arr[mid]==target)return mid;
        if(arr[mid]>target)end=mid-1;
        else start=mid+1;
        return binarySearch(arr,target,start,end);
    }
}
