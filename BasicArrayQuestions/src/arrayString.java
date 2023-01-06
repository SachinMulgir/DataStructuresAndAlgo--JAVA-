import java.util.Scanner;

public class arrayString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] Names=new String[n];
        for(int i=0;i<n;i++){
            Names[i]=sc.nextLine();
        }
        System.out.println(Names.length);
        for(int i=0;i<Names.length;i++){
            System.out.println(Names[i]);
        }
    }
}
