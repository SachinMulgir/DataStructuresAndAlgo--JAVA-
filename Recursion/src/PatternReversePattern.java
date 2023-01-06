// * * * *
// * * *
// * *
// *

import java.util.Scanner;

public class PatternReversePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printStars(n,0);
    }
    public static void printStars(int row, int col){
        if( row == -1 ){
            return;
        }
        if( col < row ){
            System.out.print("*"+" ");
            printStars(row,col+1);
        }else{
            System.out.println();
            printStars(row-1,0);
        }
        return;
    }
}
