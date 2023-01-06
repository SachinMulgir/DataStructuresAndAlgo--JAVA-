import java.util.Scanner;

public class TriangularNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        System.out.println(isTriangular(n));
    }
    public static int isTriangular( int n){
        int start = 0 ;
        int end = n;
        while( start <= end ){
            int mid = start + (end - start) / 2;
            int tNum = (mid * (mid + 1) )/2;
            if( n == tNum ){
                return 1;
            }else if( tNum > n ){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return 0;
    }

}
