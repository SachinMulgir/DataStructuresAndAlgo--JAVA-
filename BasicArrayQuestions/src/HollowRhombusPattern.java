//HOLLOW RHOMBUS PATTERN
//    *****                   the coordinates of star are:  (when n=5)
//   *   *                                                  first row and last row when i=1 or i=n(1,1 1,2 1,3 1,4 1,5) && (5,1 5,2 5,3 5,4 5,5)
//  *   *                                                   next 3 rows: when j=1 or j=n: (2,1 2,n 3,1 3,n 4,1 4,n)
// *   *
//*****
public class HollowRhombusPattern {
    public static void main(String[] args) {
        int n=5;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for (int j=1;j<=n;j++){
                if( i==1 || j==1 || i==n || j==n) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
