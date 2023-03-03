import java.util.*;
public class Q_NoOfSubstringContainingAllChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // substring containing all (a,b,c) chars.......
        System.out.println(NumberOfSubstrWithAllChar(s));
    }
    private static boolean contains(Map<Character,Integer> hm){
        return ( hm.containsKey('a') && hm.containsKey('b') && hm.containsKey('c') );
    }
    public static int NumberOfSubstrWithAllChar(String s){
        Map<Character, Integer> hm = new HashMap<>();
        int end = 0;
        int n = s.length();
        int start = 0;
        int ans = 0;

        while( end < n ){

            //1.Expansion:
            char chEnd = s.charAt(end);
            hm.put(chEnd, hm.getOrDefault(chEnd,0) + 1);
            end++;

            //2.Contraction
            while( start < end && end == n ){
                if( contains(hm) ){
                    ans++;
                }
                char chStart = s.charAt(start);
                hm.put( chStart, hm.get(chStart) - 1);
                if( hm.get(chStart) == 0)hm.remove(chStart);
                start++;
            }

            if( contains(hm) ){
                ans++;
            }
        }
        return ans;
    }
}
