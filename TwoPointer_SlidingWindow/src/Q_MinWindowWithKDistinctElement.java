import java.util.*;
public class Q_MinWindowWithKDistinctElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("k:");
        int k = sc.nextInt();

        System.out.println( minWindowWithKdistinct(arr, k ) );
    }
    public static List<Integer> minWindowWithKdistinct(int[] arr, int k){
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[2];
        int minLen = Integer.MAX_VALUE;
        Map<Integer, Integer> hm = new HashMap<>();

        int n = arr.length;
        int start = 0;
        int end = 0;
        int distinct = 0;
        boolean possible = false;

        while( end < n ){

            //1.Expansion:
            int valEnd = arr[end];
            hm.put(valEnd , hm.getOrDefault(valEnd , 0) + 1);
            if( hm.get(valEnd) == 1 )distinct++;
            end++;

            //2.Contraction:
            while( start < end && distinct == k){
                if( minLen > (end - start) ){
                    minLen = end - start;
                    ans[0] = start;
                    ans[1] = end - 1;
                }
                possible = true;
                int valStart = arr[start];
                hm.put(valStart , hm.get(valStart) - 1);
                if( hm.get(valStart) == 0 )distinct--;
                start++;
            }
        }
        if( possible ){
            list.add(ans[0]);
            list.add(ans[1]);
        }else{
            list.add(-1);
        }
        return list;
    }
}





















