import java.util.*;
public class Q_PairSumDivisibleByK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("K : ");
        int k = sc.nextInt();

        int count = pairSumK(arr,k);
        System.out.println(count);
    }
    public static void hashmapAdd(Map<Integer, Integer> hm, int remainder){
        if( hm.containsKey(remainder) ){
            int val = hm.get(remainder);
            val++;
            hm.put(remainder, val);
        }else{
            hm.put(remainder, 1);
        }
    }
    public static int pairSumK( int[] arr, int k ){
        int count = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for( int element : arr ){
            int remainder = element % k;
            int searchRemainder = k - remainder;

            if( searchRemainder == k ){
                searchRemainder = 0;
            }

            if( hm.containsKey(searchRemainder) ){
                count = count + hm.get(searchRemainder);
            }
            hashmapAdd(hm, remainder);
        }
        return count;
    }
}
// 11
// 9 56 25 52 72 44 80 36 96 71 55