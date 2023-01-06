//ROTATED 180DEG HALF  PYRAMID
//   *  3 space 1 star
//  **  2 space 2 star
// ***  1 space 3 star
//****  0 space 4 star

public class pattern5 {
    public static void main(String[] args) {
        int n=4;
        for(int i=1;i<=n;i++){
            for(int k=n;k>i;k--){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
