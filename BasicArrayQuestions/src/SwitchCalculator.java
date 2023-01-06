import java.util.*;
public class SwitchCalculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter num1:");
        int n1=sc.nextInt();
        System.out.print("enter operation(+,-+,*,/,%):");
        char opr=sc.next().charAt(0);
        System.out.print("enter num2:");
        int n2=sc.nextInt();
        System.out.print("result:");

        switch (opr){
            case '+':
                System.out.println(n1+n2);
                break;
            case '-':
                System.out.println(n1-n2);
                break;
            case '*':
                System.out.println(n1*n2);
                break;
            case '/':
                System.out.println(n1/n2);
                break;
            case '%':
                System.out.println(n1%n2);
                break;
            default:
                System.out.println("wrong input");
        }
    }
}
