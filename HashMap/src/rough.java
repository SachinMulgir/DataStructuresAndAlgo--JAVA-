import java.util.*;
public class rough {
    public static void main(String[] args) {
        String s = "abcd";
        subString("",s);
        System.out.println();
    }
    public static void subString(String p, String s){
        if( s.length() == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);

        }
        char ch = s.charAt(0);
        String ss = s.substring(1);
        ArrayList<String> sAns = new ArrayList<>();
         subString(p+ch,ss) ;


    }
}
