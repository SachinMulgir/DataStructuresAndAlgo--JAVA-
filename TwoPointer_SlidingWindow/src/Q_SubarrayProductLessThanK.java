import java.util.*;
// No of subarrays with product less than k
public class Q_SubarrayProductLessThanK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("enter k:");
        int k = sc.nextInt();

        //solution
        System.out.println(numSubarrayProductLessThanK(arr, k));
    }
    public static int numSubarrayProductLessThanK(int[] arr, int k){
        int n = arr.length;
        int start = 0;
        int end = 0;
        int ans = 0;
        int product = 1;

        while( end < n ){
            // 1. Expansion: expand till the product is less than K
            product *= arr[end];
            end++;

            // 2. Contraction: when product >= k, move start forward and decrease product:
            while( start < end && product >= k ){
                product /= arr[start];
                start++;
            }

            // 3. Calculation : whenever the product is less than k, we'll add the count of subarrays to answer
            if( product < k ){
                ans += (end - start);
            }
        }
        return ans;
    }
}
