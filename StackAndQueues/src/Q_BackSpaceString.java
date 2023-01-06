import java.util.*;
// '#' is considered as backspace i.e it'll remove last character from string
// ab# == a   ( # will remove b )

public class Q_BackSpaceString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        boolean ans = backspaceString(s,t);
        if(ans){
            System.out.print(" equal ");
        }else{
            System.out.print(" not equal ");
        }
    }
    public static void evaluate( Stack<Character> st , char ch){
        if( ch == '#' ){
            if( st.size() == 0 ){
                return;
            }
            st.pop();
        }else{
            st.push(ch);
        }
    }
    public static boolean backspaceString(String s, String t){
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            evaluate( st1, ch );
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            evaluate( st2, ch );
        }

        if( st1.size() != st2.size() ){
            return false;
        }
        while( st1.size() > 0 ){
            char ch1 = st1.pop();
            char ch2 = st2.pop();
            if( ch1 != ch2 ){
                return false;
            }
        }
        return true;
    }
}
