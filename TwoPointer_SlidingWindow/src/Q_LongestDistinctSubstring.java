import java.util.*;
public class Q_LongestDistinctSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println( longestDistinctSubstr(s) );
    }
    public static int longestDistinctSubstr(String s){

        Map<Character, Integer> hm = new HashMap<>();
        int start = 0;
        int end = 0;
        int n = s.length();
        int repeat = 0;
        int ans = 0;

        while( end < n ){

            // 1. Expansion:\
            hm.put(s.charAt(end), hm.getOrDefault(s.charAt(end) , 0) + 1);
            if( hm.get(s.charAt(end)) > 1 )repeat++;
            end++;

            // 2. Contraction:
            while( start < end && repeat > 0 ){
                if(hm.get(s.charAt(start)) > 1 ){
                    repeat--;
                }
                hm.put(s.charAt(start) , hm.get(s.charAt(start)) - 1);
                start++;
            }

            //3. Calculation:
            if( repeat == 0 ){
                ans = Math.max(ans, (end - start));
            }

        }
        return ans;
    }
}
