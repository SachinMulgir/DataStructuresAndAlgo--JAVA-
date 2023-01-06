import java.util.*;
public class functionMultipleOption {
    Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose from the options:");
        System.out.println("1.Function for 3 inputs and printing their average");
        System.out.println("2.Function for sum  of all odd numbers up to n.");
        System.out.println("3,Function to check the eligibility for voting");
        System.out.println("4.Function to print Fibonacci Series.");
        System.out.println("5.Function to take as many input as user want and then print the number of positive,negative and 0 inputs.");
        System.out.println();
        System.out.print("Select(1-5):");
        int n=sc.nextInt();
        switch (n){
            case 1:
                System.out.print("Enter 3 Numbers:");
                int a=sc.nextInt();
                int b=sc.nextInt();
                int c=sc.nextInt();
                System.out.println("average of "+a+" "+b+" "+c+" is: "+ averageOfThreeNumbers(a,b,c));
               break;

            case 2:
                System.out.print("enter n:");
                int x=sc.nextInt();
                System.out.println(sumOfOdd(x));
                break;

            case 3:
                System.out.print("enter age:");
                int y=sc.nextInt();
                checkAge(y);
                break;

            case 4:
                System.out.print("Enter length of Fibonacci Series:");
                int m=sc.nextInt();
                fibonacciSeries(m);
                break;

            case 5:
                checkInput();
            break;
            default:
                System.out.println("wrong input");
        }

    }
    public static float averageOfThreeNumbers(int a, int b,int c){
        return (a+b+c)/3;
    }
    public static int sumOfOdd(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            if(i%2!=0){
                sum=sum+i;
            }
        }
        return sum;
    }
    public static void checkAge(int a){
        if(a>=18){
            System.out.println("eligible");
        }else{
            System.out.println("not eligible");
        }
    }

    public static void fibonacciSeries(int n){
        int x=0;
        int y=1;
        int sum=0;
        System.out.println(x);
        System.out.println(y);
        for(int i=2;i<=n;i++){
            sum=x+y;
            x=y;
            y=sum;
            System.out.println(sum);
        }
    }
    public static void checkInput(){
        Scanner sc=new Scanner(System.in);
        int a,b;
        int countPositive=0;
        int countNegative=0;
        int countZero=0;
        do{
            System.out.print
                    ("enter num:");
            a=sc.nextInt();
            if(a>=1)countPositive++;
            if(a<1)countNegative++;
            if(a==0)countZero++;
            System.out.println("want to continue giving input?\npress '1' to continue.\npress '0' to exit and see result.");
            b=sc.nextInt();
        }while (b==1);
        System.out.println("Positive Input:"+countPositive+"\nNegative Inputs:"+countNegative+"\nZero Input:"+countZero);
    }
}
