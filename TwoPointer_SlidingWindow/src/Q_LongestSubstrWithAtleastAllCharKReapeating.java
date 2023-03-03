import java.util.*;
public class Q_LongestSubstrWithAtleastAllCharKReapeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println("k:");
        int k = sc.nextInt();

        System.out.println(longestSubstrWithKrepeat(s,k));
    }
    public static int xUniqueK(String s, int x , int k){

        Map<Character,Integer> hm = new HashMap<>();      //to store values with freq

        int start = 0;
        int end = 0;
        int uniq = 0;                       // running unique element
        int charK = 0;                      // running element with freq >= k
        int ans = 0;

        while( end < s.length() ){

            //1.Expansion:
            // we'll expand till we have uniq <= x
            char chEnd = s.charAt(end);
            hm.put( chEnd , hm.getOrDefault( chEnd , 0) + 1);
            if( hm.get(chEnd) == 1 )uniq++;           // increment uniq whenever new element added to map
            if( hm.get(chEnd) == k )charK++;          // increment charK whenever the freq == k
            end++;

            //2.Contraction:
            // when uniq > x (we'll contract) and try to bring it back in range
            while( start < end && uniq > x ){
                char chStart = s.charAt(start);
                hm.put( chStart, hm.getOrDefault( chStart, 0) - 1 );
                if( hm.get(chStart) == k-1 )charK--;    // when freq = k - 1 , i.e charK--;
                if( hm.get(chStart) == 0 )uniq--;       // when freq = 0, i.e it is no more in map. uniq--
                start++;
            }

            //3.calculation
            if( uniq == x && charK == x ){              // calculate when uniq = x and charK = x;
                ans = Math.max(ans, (end - start) );
            }
        }
        return ans;
    }
    public static int longestSubstrWithKrepeat(String s , int k){
        int ans = 0;
        Map<Character, Integer> hm = new HashMap<>();
        for( int i = 0 ; i < s.length() ; i++){
            hm.put(s.charAt(i) , 1 );                 // store all unique keySet() with freq 1;
        }
        int unique = hm.size();                      // total no of unique element;
        System.out.println("unique: " + unique);
        for (int i = 1; i <= unique; i++) {
            ans = Math.max(ans, xUniqueK(s, i, k));    // call for 'i' unique, 'k' repeat
        }
        return ans;
    }
}
