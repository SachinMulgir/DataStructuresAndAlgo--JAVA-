import java.util.Scanner;

public class arrayCheckAscending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        boolean ascending=true;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                ascending=false;
            }
        }
        if(ascending) System.out.println("ascending");
        else System.out.println("not ascending");

    }
}
