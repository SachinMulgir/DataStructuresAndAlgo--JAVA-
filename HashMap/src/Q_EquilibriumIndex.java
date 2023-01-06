import java.util.*;
public class Q_EquilibriumIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("equilibrium index : " + equilibriumIndex(arr));
    }
    public static int equilibriumIndex(int[] arr){
        int n = arr.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += arr[i];
        }
        int lSum = 0;
        for (int i = 0; i < n; i++) {
            int rSum = total - lSum - arr[i];
            if( lSum == rSum ){
                return i;
            }
            lSum += arr[i];
        }
        return -1;
    }
}
