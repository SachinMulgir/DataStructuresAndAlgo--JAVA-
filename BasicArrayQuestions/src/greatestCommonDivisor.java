import java.util.Scanner;

public class greatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int n;
        int gcd=1;
        if(a>b)n=a;
        else n=b;
        for(int i=1;i<=n/2;i++){
            if(a%i==0 && b%i==0){
                gcd=i;
            }
        }
        System.out.println(gcd);
    }
}
