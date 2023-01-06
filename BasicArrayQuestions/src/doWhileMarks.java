import java.util.Scanner;

public class doWhileMarks {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        do{
            System.out.println("Enter a number \n1.Enter marks:\n0.exit");
            n=sc.nextInt();
            if(n==1){
                System.out.print("Enter marks:");
                int marks=sc.nextInt();
                if(marks>=90){
                    System.out.println("This is good.");
                }else if(marks>=60 && marks<90){
                    System.out.println("This is also good.");
                }else{
                    System.out.println("This is good as well");
                }
            }
            System.out.println();
        }while(n==1);
    }
}
