import java.util.*;
public class binarySearchMatrix {
    public static void main(String[] args) {
        int[][] matrix={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int target=2;
        int[] ans=search(matrix,target);
        System.out.println(Arrays.toString(ans));
    }
    //here  we are searching for the target element along the row
    //where the row is given and cStart and cEnd are the start and end points
    //when we'll be left with the last section of the matrix,we'll be calling this binarySearch() function
    //then we perform normal binary search on them
    static int[] binarySearch(int[][] matrix,int row,int cStart, int cEnd,int target){
        while(cStart<=cEnd){
            int mid=cStart+(cEnd-cStart)/2;
            if(matrix[row][mid]==target)return new int[]{row,mid};
            if(matrix[row][mid]<target)cStart=mid+1;
            else cEnd=mid-1;
        }
        return new int[]{-1,-1};
    }
    //binarySearch is over


    static int[] search(int[][] matrix,int target){
        //initials taken,
        int rows=matrix.length;
        int cols=matrix[0].length;
        //if it is having only one row(i.e like an array)
        if(rows==1){
            return binarySearch(matrix,0,0,cols-1,target);
        }
        //we'll run the loop till only 2 rows are remaining. i.e 2 rows means: (rEnd and rEnd-1);
        int rStart=0;
        int rEnd=rows-1;
        int cMid=cols/2;                        //we're doing it along the column therefore we need a middle column

        while(rStart<rEnd-1){                   //condition for only two  rows.(it'll run till we are left with only 2 rows)
            int mid=rStart+(rEnd-rStart)/2;     //since it's a strictly sorted matrix, each element is greater than the previous element
            if(matrix[mid][cMid]==target){      //therefore  if element>target(we'll skip the bottom rows of the element since they'll also be >target
                return new int[]{mid,cMid};    //if element<target: we'll skip the upper rows since all will be <target
            }
            if(matrix[mid][cMid]<target){
                rStart=mid;
            }else{
                rEnd=mid;
            }
        }

        //now we have 2 rows
        //check whether the target in the column
        if(matrix[rStart][cMid]==target){
            return new int[]{rStart,cMid};
        }
        if(matrix[rStart+1][cMid]==target){
            return new int[]{rStart+1,cMid};
        }
        //Start searchin in the remaining halves

        //search in 1st half
        if(target<=matrix[rStart][cMid-1]){
            return binarySearch(matrix,rStart,0,cMid-1,target);
        }
        //search in 2nd half
        if(target>=matrix[rStart][cMid+1] && target<=matrix[rStart][cols-1]){
            return binarySearch(matrix,rStart,cMid+1,cols-1,target);
        }
        if(target<matrix[rStart+1][cMid-1]){
            return binarySearch(matrix,rStart+1,0,cMid-1,target);
        }
        else{
            return binarySearch(matrix,rStart+1,cMid+1,cols-1,target);
        }
    }
}
