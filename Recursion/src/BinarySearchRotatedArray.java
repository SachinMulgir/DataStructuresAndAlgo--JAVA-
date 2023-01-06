public class BinarySearchRotatedArray {
    public static void main(String[] args) {
        int[] arr = { 4 ,7, 8, 9, 10, 1, 3};
        int target = 10;
        System.out.println(rotatedBinarySearch(arr,target,0,arr.length-1));
    }
    public static int rotatedBinarySearch(int[] arr, int target, int start, int end){
        if(start > end)return -1;
        int mid = start + (end-start)/2;

        if(arr[mid] == target)return mid;
        if(arr[mid] >= arr[start]) {
            if (target <= arr[mid] && target >= arr[start]){
                return rotatedBinarySearch(arr,target,start,mid-1);
            }
            else{
                return rotatedBinarySearch(arr,target,mid+1,end);
            }
        }
        if(target >= arr[mid] && target <= arr[end]){
            return rotatedBinarySearch(arr,target,mid+1,end);
        }else{
            return rotatedBinarySearch(arr,target,start,mid-1);
        }
    }
}
