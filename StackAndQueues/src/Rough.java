import java.util.*;
public class Rough {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(infected(n, x, y));



    }

//        static int MODULO = 1000000007;

    public static long numInfected(long x, long y, long n) {
        long totalInfected = 1;
        long currentDay = 1;
        while (currentDay < n) {
            if (currentDay < x) {
                totalInfected = totalInfected * 2;
            } else if (currentDay >= x && currentDay < (x + y)) {
                totalInfected = totalInfected + 1;
            } else {
                totalInfected = totalInfected - 1;
            }
            currentDay++;
        }
        // calculate modulo
        return totalInfected % (long)(Math.pow(10, 9) + 7);
    }
    public static int infected(int days ,int x,int y){
        if (days < x)
        return 0;
        else if (days < x + y)
        return (1 + infected(days - 1,x,y))% (1000000000 + 7);
        else{
            return( infected(days - 1 , x ,y) + infected(days - x - y , x , y) ) % (1000000000+ 7);
        }
    }


}
