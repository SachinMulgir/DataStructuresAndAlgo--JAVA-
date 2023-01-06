//we have to fine the no of Odd elements present in the array after we do the increment on the matrix according
//to the given indices, i.e for indices[i]=(0,1) we will increment row=0 and col=1 by 1.and so on
//here the increment will be like this:
//  [0,0,0] -> [1,2,1] -> [1,3,1]
//  [0,0,0]    [0,1,0]    [1,3,1]
//  initial    for(0,1)  for(1,1)
//
import java.util.*;
public class matrixODDValues {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=2;
        int n=3;
        int[][] indices={ {0,1},
                          {1,1}
                        };
        int[][] matrix=new int[m][n];
        ArrayList<Integer> list=new ArrayList<>();
        //initially all the elements of this matrix are 0;
        for(int i=0;i<indices.length;i++){
            for(int j=0;j<indices[i].length;j++){

            }
        }

    }
}
