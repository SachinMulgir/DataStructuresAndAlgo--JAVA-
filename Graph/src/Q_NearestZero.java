import java.util.*;
public class Q_NearestZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        //
        grid = nearestZero(grid);
        System.out.println("Nearest zero grid:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[] dr = new int[]{-1,0,1,0};
    static int[] dc = new int[]{0,1,0,-1};
    public static int[][] nearestZero(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        bfs(grid,visited);
        return grid;

    }
    public static void bfs(int[][] grid, boolean[][] visited ){
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if( grid[i][j] == 0){
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int level = 1;

        while( q.size() > 0 ){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                //RPA:
                //Remove:
                int temp[] = q.remove();

                //Process:
                int row = temp[0];
                int col = temp[1];

                //Add:
                for (int j = 0; j < 4; j++) {
                    int nr = row + dr[j];
                    int nc = col + dc[j];

                    if( nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length ){
                        continue;
                    }
                    if( visited[nr][nc] == false ){
                        visited[nr][nc] = true;
                        grid[nr][nc] = level;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            level++;
        }
    }
}
/*
3 3
0 0 0
0 1 0
1 1 1
 */