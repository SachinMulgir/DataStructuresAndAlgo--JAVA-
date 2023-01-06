import java.util.Scanner;
//leetCode: 509 (easy)
//https://leetcode.com/problems/fibonacci-number/

public class recursionFibonacci {

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            System.out.println(fibo(n));
        }
        public static int fibo(int n){
            //base condition: it is the condition where the recursion will break.
            if(n<2){
                return n;
            }

            //recursion condition: where it'll call itself and keep calling it till the base condition is reached.
            return fibo(n-1) + fibo(n-2);
        }

}






