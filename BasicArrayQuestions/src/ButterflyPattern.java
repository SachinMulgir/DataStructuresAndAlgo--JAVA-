//BUTTERFLY PATTERN
//             star     spaces     star
//*      *      1         6         1
//**    **      2         4         2
//***  ***      3         2         3
//********      4         0         4
//********          the lower area is just inverted part of the upper 4 rows...just change the loop conditions.
//***  ***
//**    **
//*      *
public class ButterflyPattern {
    public static void main(String[] args) {
        int n=4;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

//        for(int i=1;i<=n;i++){
//            for(int j=1;j<=n-i+1;j++){
//                System.out.print("*");
//            }
//
//            for(int j=1;j<=2*(i-1);j++){
//                System.out.print(" ");
//            }
//
//            for(int j=1;j<=n-i+1;j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        OR
        for(int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
