import java.util.*;
public class Q_BalancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(balancedBrackets(s));
    }
    public static boolean balancedBrackets(String s){
        Stack<Character> st = new Stack<>();
        for( int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if( ch == '(' || ch == '[' || ch == '{' ){
                st.push(ch);
            }else if( ch == ')' || ch == ']' || ch == '}' ){
                if( st.size() == 0){           // check if the stack has any element to compare
                    return false;               // s = " ] ";
                }
                if( st.peek() != opposite(ch) ){
                    return false;
                }else{
                   st.pop();
                }
            }
        }
        if( st.size() != 0 ){                   // check if the stack is empty before returning true
            return false;                       // s = " { ";
        }
        return true;
    }
    public static char opposite(char ch){
        if ( ch == ')' ) return '(';
        else if ( ch == ']' ) return '[';
        else return '{';
    }
}
