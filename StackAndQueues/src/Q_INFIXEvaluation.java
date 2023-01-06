import java.util.*;
// + == -
// * == /
// (*,/) > (+,-)
// if equal precedence ....whichever on left is solved first;
public class Q_INFIXEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        // Infix Evaluation:
        int ans = infixEvaluation(s);
        System.out.println(ans);
    }
    public static int infixEvaluation( String s ){
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // there are 4 possibilities of character being a :
            // 1. operand ( 0 - 9 ) :
            if( Character.isDigit(ch) ){
                operand.push(ch - '0' );
            }

            // 2. opening bracket '(' :
            if( ch == '(' ){
                operator.push( ch );
            }

            // 3. closing bracket ')' :
            if( ch == ')' ){
                while( operator.peek() != '(' ){
                    solveStack(operand,operator);
                }
                operator.pop();
            }

            // 4. operator ( + , - , * , / ) :

            if( ch == '*' || ch == '/' || ch == '+' || ch == '-') {

                while (operator.size() != 0 && operator.peek() != '(' && priority(ch) <= priority(operator.peek())) {
                    solveStack(operand,operator);
                }
                operator.push(ch);
            }
        }
        while( operator.size() > 0 ){
            solveStack(operand,operator);
        }
        return operand.peek();
    }
    public static void solveStack(Stack<Integer> operand , Stack<Character> operator){
        char operation = operator.pop();
        int v2 = operand.pop();
        int v1 = operand.pop();
        int newVal = calculate( v1, v2, operation);
        operand.push(newVal);
    }
    public static int calculate( int a, int b , char ch){
        if( ch == '+' ){
            return a + b;
        }else if ( ch == '-'){
            return a - b;
        }else if ( ch == '*' ){
            return a * b;
        }else{
            return a / b;
        }
    }
    public static int priority(char ch){
        if( ch == '+' || ch == '-' ){
            return 0;
        }else{
            return 1;                   // for '*' and '/'
        }
    }
}
