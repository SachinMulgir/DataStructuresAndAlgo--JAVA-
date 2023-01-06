import java.util.*;
public class Q_PrefixEvaluationAndConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        prefix(s);
    }
    public static int evaluate(int a, int b, char ch){
        if( ch == '*' ){
            return a*b;
        }else if( ch == '/' ){
            return a/b;
        }else if( ch == '+' ){
            return  a + b;
        }else{
            return a - b;
        }
    }
    public static void prefix(String s){
        Stack<Integer> value = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for (int i = s.length() - 1 ; i >= 0 ; i-- ) {
            char ch = s.charAt(i);
            if( ch == '*' || ch == '/' || ch == '+' || ch == '-' ){
                int v1 = value.pop();
                int v2 = value.pop();
                int newVal = evaluate(v1,v2,ch);
                value.push(newVal);

                String infixV1 = infix.pop();
                String infixV2 = infix.pop();
                String newInfix = "(" + infixV1 + ch + infixV2 + ")";
                infix.push(newInfix);

                String postfixV1 = postfix.pop();
                String postfixV2 = postfix.pop();
                String newPost = postfixV1 + postfixV2 + ch;
                postfix.push(newPost);

            }else{
                value.push(ch - '0');
                infix.push(ch + "");
                postfix.push( ch + "");
            }
        }
        System.out.println("Value : " + value.pop() );
        System.out.println("Infix : " + infix.pop() );
        System.out.println("Postfix : " + postfix.pop() );
    }
}
//-+2/*6483
