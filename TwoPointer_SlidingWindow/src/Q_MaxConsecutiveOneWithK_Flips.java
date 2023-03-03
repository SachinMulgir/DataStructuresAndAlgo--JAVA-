import java.util.*;
public class Q_MaxConsecutiveOneWithK_Flips {
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
        System.out.println(maxConsOneWithKflips(arr, k));
    }
    public static int maxConsOneWithKflips(int[] arr, int k){
        int n = arr.length;
        int start = 0;
        int end = 0;
        int ans = 0;

        while( end < n ){

            // 1. Expansion: move forward till you convert k no. of 0s to 1
            if( arr[end] == 0 ){
                k--;
            }
            end++;

            // 2. Contraction: when k < 0, then move start forward till you find 0 and move the window forward
            while( start < end && k < 0 ){
                if( arr[start] == 0 )k++;
                start++;
            }

            // 3. Calculation: every time k is valid, calculate the length and store the max;
            if( k >= 0 ){
                ans = Math.max(ans, (end - start) );
            }
        }
        return ans;
    }
}
/*
11
1 1 1 0 0 0 1 1 1 1 0
 */