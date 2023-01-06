import java.util.*;
public class Q_LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        longestConsSeq(arr);
    }
    public static void longestConsSeq(int[] arr){
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for( int val : arr ){
            hm.put( val, true);
        }
        // again iterate to check for starting points of sequence
        for( int val : arr ){
            if( hm.containsKey(val - 1) ){
                hm.put(val, false);
            }
        }
        // now starting points have true value with them
        // at each starting point run a while loop to check how many later numbers are present in array
        int ms = 0;
        int start = 0;
        for( int val : arr ){
            if( hm.get(val) == true ){
                int temp = val;
                int size = 0;
                while( hm.containsKey(temp) ){
                    size++;
                    temp++;
                }
                if( size > ms ){
                    ms = size;
                    start = val;
                }
            }
        }
        for (int i = 0; i < ms; i++) {
            System.out.print(start++ + " ");
        }
    }
}
