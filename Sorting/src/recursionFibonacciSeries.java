import java.util.*;
//we'll take an example of Nth fibonacci number in the series.
//fibonacci series: 0 1 1 2 3 5 8 13 21 34 55 89 144............
//Recurrence relation: fibo(N)=fibo(N-1) + fibo(N-2);     {equation to apply for the condition}
public class recursionFibonacciSeries {
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
        //and the control will move back to the place of the function call.
        //-------------------------------------------------------------------------
        //recursion condition: where it'll call itself and keep calling it till the base condition is reached.
        return fibo(n-1) + fibo(n-2);
    }

}
//if we take n=4; first it'll call fibo(3) + fibo(2)
// L.H.S first (i.e fibo(3)) will run first
//fibo(3)-> fibo(2)+fibo(1);
//again to the L.H.S of the above equation (i.e fibo(2))
//fibo(2)-> fibo(1)+fibo(0).

//above steps will continue accordingly.then it'll do the same on R.H.S


// C.A.L.L  S.T.A.C.K
//
// fibo(0)
// fibo(1)
// fibo(2)
// fibo(1)
// fibo(0)
// fibo(1)           so on......
// fibo(2)           third
// fibo(3)           second
// fibo(4)           first



