import java.util.*;
public class Q_MinimumWindowSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        //solution:
        String ans = minWindowSubstr(s,t);
        System.out.println(ans);
    }
    public static boolean checkPresence(Map<Character, Integer> shm, Map<Character, Integer> thm){
        for( char ch : thm.keySet() ){
            if( shm.containsKey(ch) == false ){
                return false;
            }
            if( shm.get(ch) <  thm.get(ch) )return false;
        }
        return true;
    }
    public static String minWindowSubstr(String s, String t){
        Map<Character, Integer> shm = new HashMap<>();
        Map<Character, Integer> thm = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            thm.put(ch , thm.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        int ansStart = 0;
        int ansEnd = 0;

        while( end < s.length() ){

            //1. Expansion:
            char chEnd = s.charAt(end);
            shm.put( chEnd, shm.getOrDefault(chEnd, 0) + 1 );
            end++;

            //2. Contraction:
            while( start < end && checkPresence(shm,thm) ){
                if( ans > (end - start ) ){
                    ans = end - start;
                    ansStart = start;
                    ansEnd = end;
                }
                char chStart = s.charAt(start);
                shm.put( chStart, shm.get(chStart) - 1);
                if( shm.get(chStart) == 0 )shm.remove(chStart);
                start++;
            }

        }
        if( ansStart == ansEnd )return "";
        return s.substring(ansStart,ansEnd);
    }
}
/*
s = "ADOBECODEBANC";
t = "ABC";
 */