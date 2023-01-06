import java.util.*;
public class Q_HighestFreqCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(highestFreqChar(s));
    }
    public static char highestFreqChar(String s){
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if( hm.containsKey(ch) ){
                hm.put(ch, hm.get(ch) +1);
            }else{
                hm.put( ch, 1 );
            }
        }
        System.out.println(hm);

        char mfc = s.charAt(0);
        for( char ch : hm.keySet()){
            if( hm.get(ch) > hm.get(mfc) ){
                mfc = ch;
            }
        }
        return mfc;
    }
}
