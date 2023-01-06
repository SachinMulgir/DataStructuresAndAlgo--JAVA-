import java.util.*;
public class Q_PostFixEvaluationAndConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        PostFix(s);
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
    public static void PostFix(String s){
        Stack<Integer> value = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if( ch == '*' || ch == '/' || ch == '+' || ch == '-' ){
                int v2 = value.pop();
                int v1 = value.pop();
                int newVal = evaluate(v1,v2,ch);
                value.push(newVal);

                String infixV2 = infix.pop();
                String infixV1 = infix.pop();
                String newInfix = "(" + infixV1 + ch + infixV2 + ")";
                infix.push(newInfix);

                String prefixV2 = prefix.pop();
                String prefixV1 = prefix.pop();
                String newPre = ch + prefixV1 + prefixV2;
                prefix.push(newPre);

            }else{
                value.push(ch - '0');
                infix.push(ch + "");
                prefix.push( ch + "");
            }
        }
        System.out.println("Value : " + value.pop() );
        System.out.println("Infix : " + infix.pop() );
        System.out.println("Prefix : " + prefix.pop() );
    }
}
