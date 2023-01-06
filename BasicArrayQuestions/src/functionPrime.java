import java.util.Scanner;

public class functionPrime {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        checkPrime(n);
    }
    public static void checkPrime(int n){
        int count=0;
        for(var i=2;i<=n/2;i++){
            if(n%i==0){
                count++;
            }
        }
        if(count==0){
            System.out.println("prime");
        }else{
            System.out.println("not prime");
        }
    }
}
