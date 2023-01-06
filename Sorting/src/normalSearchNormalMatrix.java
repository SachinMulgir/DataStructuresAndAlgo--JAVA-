import java.util.Arrays;
import java.util.*;
//this is for a matrix with sorted values in increasing values........but not strictly increasing.
public class normalSearchNormalMatrix {
    public static void main(String[] args) {
            int[][] matrix={{10,20,30,40},
                    {15,25,35,45},
                    {28,29,37,49},
                    {33,34,38,50}};
            int target=288;
            int[] ans=bsMatrix(matrix,target);
            System.out.println(Arrays.toString(ans));
        }
        public static int[] bsMatrix(int[][] matrix,int target){
            int r=0;
            int c=matrix.length-1;
            while(r<matrix.length && c>=0){
                if(matrix[r][c]==target)return new int[]{r,c};
                if(matrix[r][c]>target)c--;
                else r++;
            }
            return new int[]{-1,-1};
        }
}
