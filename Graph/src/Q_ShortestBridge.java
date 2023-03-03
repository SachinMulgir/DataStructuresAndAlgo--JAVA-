import java.util.*;
public class Q_ShortestBridge {
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

        //Solution:
        int ans = shortestBridge(grid);
        System.out.println("ans: "+ ans);
    }
    static int[] dr = new int[]{-1,0,1,0};
    static int[] dc = new int[]{0,1,0,-1};

    public static int shortestBridge(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        boolean flag = false;
        for( int i = 0 ; i < rows && !flag; i++){
            for( int j = 0 ; j < cols && !flag; j++){
                if( grid[i][j] == 1 ){
                    q.add(new int[]{i,j});
                    dfs(grid,visited,i,j,q);
                    flag = true;
                }
            }
        }

        int level = 0;

        while( q.size() > 0 ){
            int size = q.size();
            for( int i = 0 ; i < size ; i++){
                //remove:
                int[] temp = q.remove();

                //process:
                int r = temp[0];
                int c = temp[1];

                //Add:
                for( int j = 0 ; j < 4 ; j++){
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if( nr < 0 || nc < 0 || nr >= rows || nc >= cols ){
                        continue;
                    }

                    if( visited[nr][nc] == false && grid[nr][nc] == 1 ){
                        return level;
                    }
                    if( visited[nr][nc] == false ){
                        visited[nr][nc] = true;
                        q.add(new int[]{nr,nc});
                    }
                }

            }
            level++;
        }
        return level;
    }
    public static void dfs(int[][] grid, boolean[][] visited, int r, int c, Queue<int[]> q){
        visited[r][c] = true;
        for( int i = 0 ;i < 4 ; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if( nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length){
                continue;
            }
            if( visited[nr][nc] == false && grid[nr][nc] == 1 ){
                q.add(new int[]{nr,nc});
                dfs(grid, visited, nr, nc, q);
            }
        }
    }
}
/*
5 5
1 1 0 0 0
1 0 0 0 0
1 0 0 0 0
0 0 0 1 1
0 0 0 1 1
 */