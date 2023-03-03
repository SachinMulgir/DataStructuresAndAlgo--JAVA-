import java.util.*;
public class Q_LongestSubStrWithAllChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        longestSubstrWithAllChars(s1,s2);
    }
    public static boolean check_presence(Map<Character,Integer> shm , Map<Character,Integer> thm){
        for( char ch : thm.keySet() ){
            if( shm.containsKey(ch) == false )return false;
        }
        return true;
    }
    public static void longestSubstrWithAllChars(String s, String t){

        Map<Character,Integer> thm = new HashMap<>();
        for( int i = 0 ; i < t.length() ; i++){
            char ch = t.charAt(i);
            thm.put( ch ,thm.getOrDefault(ch,0) + 1);
        }

        Map<Character,Integer> shm = new HashMap<>();
        int start = 0;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        int ansStart = -1;
        int ansEnd = -1;

        int n = s.length();

        while( end < n ){

            //1. Expansion:
            char ch = s.charAt(end);
            shm.put(ch , shm.getOrDefault(ch, 0) + 1);
            end++;

            //2. Contraction:
            while( start < end && check_presence(shm,thm) ){

            }
        }
    }
}
