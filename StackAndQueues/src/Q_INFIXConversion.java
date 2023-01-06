import java.util.*;
public class Q_INFIXConversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        infixConversions(s);
    }
    //------------------------------------------------------------
    public static int priority(char ch){
        if( ch == '+' || ch == '-' ){
            return 0;
        }else{
            return 1;                   // for '*' and '/'
        }
    }
    //-----------------------------------------------------------
    public static void evaluate(Stack<String> prefix, Stack<String> postfix, Stack<Character> operator){
        char op = operator.pop();

        String preV2 = prefix.pop();
        String preV1 = prefix.pop();
        String newPre = op + preV1 + preV2;
        prefix.push(newPre);

        String postV2 = postfix.pop();
        String postV1 = postfix.pop();
        String newPost = postV1 + postV2 + op ;
        postfix.push(newPost);
    }
    //---------------------------------------------------------------
    public static void infixConversions(String s){
        ArrayList<String> ans = new ArrayList<>();
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // there are 4 possibilities of character being a :
            // 1. operand ( 0 - 9 ) :
            if( ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9'){
               prefix.push(ch + "");
               postfix.push(ch + "");
            }


            // 2. opening bracket '(' :
            if( ch == '(' ){
                operator.push( ch );
            }



            // 3. closing bracket ')' :
            if( ch == ')' ){
                while( operator.peek() != '(' ){

                    evaluate(prefix, postfix, operator);

                }
                operator.pop();
            }


            // 4. operator ( + , - , * , / ) :
            if( ch == '*' || ch == '/' || ch == '+' || ch == '-' ) {

                while( operator.size() > 0 && operator.peek() != '(' && priority(ch) <= priority(operator.peek()) ){
                    evaluate(prefix, postfix, operator);
                }
                operator.push(ch);
            }
        }

        while( operator.size() > 0 ){
            evaluate(prefix,postfix,operator);
        }

        System.out.println("prefix : " + prefix.pop() );
        System.out.println("postfix : " + postfix.pop() );
    }
}
