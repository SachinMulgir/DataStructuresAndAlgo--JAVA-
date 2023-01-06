import java.util.*;
public class Q_MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        missingNumber(arr, arr2);
    }
    public static void missingNumber(int[] arr, int[] arr2){
        Map<Integer, Integer> hm1 = new HashMap<>();
        Map<Integer, Integer> hm2 = new HashMap<>();
        boolean found = false;                      //variable to check if any missing present or not
        for( int n : arr ){
            if( hm1.containsKey(n) ){
                int val = hm1.get(n);
                hm1.put(n, val+1);
            }
            else{
                hm1.put( n ,1 );
            }
        }
        for( int n : arr2 ){
            if( hm2.containsKey(n) ){
                int val = hm2.get(n);
                hm2.put(n, val+1);
            }
            else{
                hm2.put( n ,1 );
            }
        }
        System.out.println(" two hashmap for 2 arrays: (value, frequency) ");
        System.out.println(hm1);
        System.out.println(hm2);

        System.out.print("ans : ");
        for( int n : hm2.keySet() ){

            if( hm2.containsKey(n) == true && hm1.containsKey(n) == false ){
                System.out.print( n + " ");
                found = true;
            }
            if( ( hm1.containsKey(n) && hm2.containsKey(n) ) && hm1.get(n) != hm2.get(n) ){
                System.out.print( n + " ");
                found = true;
            }
        }
        if( found == false ){
            System.out.println(-1);
        }
    }
}
// 10 13
// 203 204 205 206 207 208 203 204 205 206
// 203 204 204 205 206 207 205 208 203 206 205 206 204