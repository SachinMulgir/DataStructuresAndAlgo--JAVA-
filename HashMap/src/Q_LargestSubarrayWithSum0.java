import java.util.*;
public class Q_LargestSubarrayWithSum0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = largestSubarraySum0(arr);
        System.out.println(ans);
    }
    public static int largestSubarraySum0(int[] arr){
        Map<Integer, Integer> hm = new HashMap<>();              // hm< sum, index >
        int sum = 0;
        int max = Integer.MIN_VALUE;
        hm.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if( hm.containsKey(sum) ) {
                int len = i - hm.get(sum);
                if (len > max) {
                    max = len;
                }
            }
            else{
                hm.put(sum, i);
            }
        }
        return max;
    }
}
//12
// 2 8 -3 -5 2 -4 6 1 2 1 -3 4

// ans = 8
// -3 -5 2 -4 6 1 2 1    => ( sum = 0 )