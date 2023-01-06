import java.util.Scanner;
//person want to climbs stairs. can take either 1 or 2 step at a time.......find minimum no.of steps he'll take to reach the top.
public class loopsMinimumSteps {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int step1,step2;
            step2=n/2;
            step1=n%2;
        System.out.println("total steps:"+(step1+step2));

    }
}
