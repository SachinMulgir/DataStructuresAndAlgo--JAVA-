import java.util.*;
public class Q_Distinct_k_chars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // k distinct char: all subsets
        int count = getDistinctCount(arr,k) - getDistinctCount(arr,k-1);
        System.out.println(count);
    }
    public static int getDistinctCount(int[] arr, int k){
        int start = 0;
        int end = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        int distinct = 0;
        int count = 0;

        while( end < arr.length ){

            //1. expansion:
            int numEnd = arr[end];
            hm.put( numEnd, hm.getOrDefault(numEnd, 0) + 1);
            if( hm.get( numEnd ) == 1 )distinct++;
            end++;

            //2. contraction:
            while( start < end && distinct > k ){
                int numStart = arr[start];
                hm.put( numStart, hm.get(numStart) - 1);
                if( hm.get(numStart) == 0 )distinct--;
                start++;
            }

            //3. calculation:
            count += end - start;
        }
        return count;
    }
}
