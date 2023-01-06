import java.util.*;
public class Q_SubarraySumEqualsK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int count = subarraySumEqualK(arr, k);
        System.out.println(count);
    }
    public static int subarraySumEqualK(int[] arr, int k){
        Map<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        int sum = 0;
        hm.put(0,1);
        for( int n : arr ){
            sum = sum + n;
            int target = sum - k;
            if( hm.containsKey(target) ){
                count += hm.get(target);
            }

            if( hm.containsKey(sum) ){
                   int val = hm.get(sum);
                   val++;
                   hm.put(sum,val);
              }else{
                   hm.put(sum, 1);
            }

        }
        return count;
    }
}
