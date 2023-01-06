public class singleElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        Solution sol = new Solution();
        sol.singleNonDuplicate(arr);
    }
}
class Solution {
    public void singleNonDuplicate(int[] arr) {
        int n = arr.length;
        for( int i = 0 ; i < n ; i++){
            int ans = binarySearch( 0 , n-1 , arr[i] , arr );
            System.out.print(ans + " ");
        }
    }
    public int binarySearch( int start, int end, int target, int[] arr){
        int count = 0;
        while( start <= end ){
            int mid = start + (end - start)/2;
            if( arr[mid] == target ){
                count++;
                if( mid<end && arr[mid + 1] == target )count++;
                else if( mid>start && arr[mid-1] == target )count++;
                return count;
            }
            else if( arr[mid] < target ){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return count;
    }
}
