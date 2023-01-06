import java.util.Scanner;
import java.util.Stack;

public class Q_DuplicateBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(balancedBracket(str));
    }
    public static boolean balancedBracket(String s) {
        Stack<Character> st = new Stack<>();
        for( int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if( ch != ')' ){
                st.push(ch);
            }
            else{
                if( st.peek() == '(' ){
                    return true;
                }else{
                    while( st.peek() != '(' ){
                        st.pop();
                    }
                    st.pop();
                }
            }
        }
        return false;
    }
}
