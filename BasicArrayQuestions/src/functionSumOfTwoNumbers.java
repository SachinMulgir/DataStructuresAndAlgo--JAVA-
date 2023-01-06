import java.util.*;

public class functionSumOfTwoNumbers {
    public static int sumOfTwo(int a,int b){
        return (a+b);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c= sumOfTwo(a,b);
        System.out.println(c);
    }
}
