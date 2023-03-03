import java.util.*;
public class Q_SnakeAndLadder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        //solution
        int minMoves = snakeAndLadder(board);
        System.out.println(minMoves);
    }

    public static int[] getCoordinates(int next, int n){
        int row = n - ( (next - 1) / n ) - 1;
        int col = (next - 1) % n;

        if( row % 2 == n % 2){
            return new int[]{row, n-1-col};
        }
        return new int[]{row , col};
    }
    public static int snakeAndLadder(int[][] board){
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(1);
        visited[n-1][0] = true;
        int moves = 0;

        while( q.size() > 0 ){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                //remove:
                int num = q.remove();

                //process:
                if( num == n*n )return moves;

                //Add:
                for (int j = 1; j <= 6; j++) {
                    int next = num + j;
                    if( next > n*n )break;

                    int[] indices = getCoordinates(next , n);
                    int r = indices[0];
                    int c = indices[1];

                    if( visited[r][c] == true )continue;

                    visited[r][c] = true;
                    if( board[r][c] != -1 ){
                        q.add(board[r][c]);
                    }
                    else{
                        q.add(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
/*
6
-1 -1 -1 -1 -1 -1
-1 -1 -1 -1 -1 -1
-1 -1 -1 -1 -1 -1
-1 35 -1 -1 13 -1
-1 -1 -1 -1 -1 -1
-1 15 -1 -1 -1 -1

 */