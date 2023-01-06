public class firstIndexOfTarget {
    public static void main(String[] args) {
        int[] arr={7,0,3,1,3,3};
        int target=1;
        System.out.println(findFirstIndex(0,arr,target));
    }
    //expectation: it'll print the index of the target element if it is present in the array
    public static int findFirstIndex(int idx, int[] arr, int target){
        if(arr[idx]==arr.length)return -1;
        if(arr[idx]==target)return idx;
        int ans=findFirstIndex(idx+1,arr,target);
        return ans;
    }
}
