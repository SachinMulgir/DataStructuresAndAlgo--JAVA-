import java.util.Scanner;

public class arrayMaxMin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            if(max<arr[i]){
                max=arr[i];
            }
            if(min>arr[i]){
                min=arr[i];
            }
        }
        System.out.println("Maximum:"+max+"\nMinimum:"+min);
    }
}
