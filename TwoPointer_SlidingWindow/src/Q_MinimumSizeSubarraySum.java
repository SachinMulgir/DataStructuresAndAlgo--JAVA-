import java.util.*;

public class Q_MinimumSizeSubarraySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("enter k:");
        int k = sc.nextInt();

        // solution
        System.out.println(minSizeSubarraySum(arr,k));
    }
    public static int minSizeSubarraySum( int[] arr, int k){
        int n = arr.length;
        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        while( end < n ){

            //1. Expansion:
            sum += arr[end];
            end++;

            //2. Contraction and Calculation:
            while( start < end && sum >= k ){
                ans = Math.min(ans, (end - start));
                sum = sum - arr[start];
                start++;
            }
        }
        return ans;
    }
}
