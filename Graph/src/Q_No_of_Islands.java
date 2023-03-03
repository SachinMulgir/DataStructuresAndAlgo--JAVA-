import java.util.*;
public class Q_No_of_Islands {
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
        // no of island:
        int ans = noOfIsland(grid);
        System.out.println(ans);
    }
    static int[] dr = new int[]{-1,0,1,0};
    static int[] dc = new int[]{0,1,0,-1};
    public static int noOfIsland(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if( grid[i][j] == 1 && visited[i][j] == false ){
                    count++;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return count;
    }

    // USING DFS:
    public static void dfs(int[][] grid, boolean[][] visited, int r, int c){
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            int rows = grid.length;
            int cols = grid[0].length;
            if( nr < 0 || nr >= rows || nc < 0 || nc >= cols){
                continue;
            }
            if( visited[nr][nc] == false && grid[nr][nc] == 1 ){
                bfs(grid,visited,nr,nc);
            }
        }
    }

    // USING BFS:

    public static void bfs( int[][] grid, boolean[][] visited, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while( q.size() > 0 ){

            int size = q.size();
            for (int i = 0; i < size; i++) {
                //RPA
                //Remove:
                int[] temp = q.remove();

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
                    if( visited[nr][nc] == false && grid[nr][nc] == 1){
                        visited[nr][nc] = true;
                        q.add( new int[]{nr,nc});
                    }
                }
            }
        }
    }
}
