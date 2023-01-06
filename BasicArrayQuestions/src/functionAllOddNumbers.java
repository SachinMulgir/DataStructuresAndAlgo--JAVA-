import java.util.Scanner;

public class functionAllOddNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(sumOfOdd(n));
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
}
