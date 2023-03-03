import java.util.*;

public class Q_AsFarAsPossibleFromLand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];         // square matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // Solution
        int ans = maxDistance(grid);
        System.out.println(ans);
    }

    static int[] dr = new int[]{-1,0,1,0};
    static int[] dc = new int[]{0,1,0,-1};
    public static int maxDistance(int[][] grid){

        int n = grid.length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if( grid[i][j] == 1 ){
                   q.add(new int[]{i,j});                //store all coordinates of 1
                   visited[i][j] = true;                 //mark all the 1 visited
                }
                else{
                    zeroCount++;                        //keep a count of no. of zeroes in grid;
                }
            }
        }

        int max = -1;
        int level = 0;

        while( q.size() > 0 ){
            int size = q.size();
            for (int i = 0; i < size; i++) {

                //Remove:
                int[] temp = q.remove();

                //Process:
                int r = temp[0];
                int c = temp[1];
                if( grid[r][c] == 0){
                    zeroCount--;
                    max = Math.max(level, max);
                }
                if( zeroCount == 0 )return max;

                //Add:
                for (int j = 0; j < 4; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if( nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length){
                        continue;
                    }

                    if( visited[nr][nc] == false ){
                        visited[nr][nc] = true;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            level++;
        }
        return max;
    }
}
