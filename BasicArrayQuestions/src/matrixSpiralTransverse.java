import java.util.Scanner;

public class matrixSpiralTransverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int[][] matrix=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int top=0,bottom=rows-1,left=0,right=cols-1;
        int dir=0;
        while(top<=bottom && left<=right){
            if(dir==0){
                for(int i=left;i<=right;i++){
                    System.out.print(matrix[top][i]+" ");
                }
                top++;
            }else if(dir==1){
                for(int i=top;i<=bottom;i++){
                    System.out.print(matrix[i][right]+" ");
                }
                right--;
            }else if(dir==2){
                for(int i=right;i>=left;i--){
                    System.out.print(matrix[bottom][i]+" ");
                }
                bottom--;
            }else if(dir==3){
                for(int i=bottom;i>=top;i--){
                    System.out.print(matrix[i][left]+" ");
                }
                left++;
            }
            dir=(dir+1)%4;
        }
    }
}
