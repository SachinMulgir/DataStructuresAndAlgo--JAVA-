//INVERTED HALF NUMBER PYRAMID
// 1111
// 222
// 33
// 4
public class InvertedNumberHalfPyramid {
    public static void main(String[] args) {
        int n=4;
        for(int i=1;i<=n;i++){
            for(int j=1;j<n;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(n-i)+1;j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
