import java.util.*;
public class Q_MaxAreaOfIsland {
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

        // max area of island:
        int ans = maxAreaOfIsland(grid);
        System.out.println("max area:");
        System.out.println(ans);
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for( int i = 0 ; i < rows; i++){
            for( int j = 0 ; j < cols ; j++){
                if( grid[i][j] == 1 && visited[i][j] == false ){
                    int area = bfs(grid,visited,i,j);
                    System.out.print("area:");
                    System.out.println(area);
                    if( area > maxArea ){
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    static int[] dr = new int[]{-1,0,1,0};
    static int[] dc = new int[]{0,1,0,-1};

    // Using dfs:
    public static int dfs(int[][] grid, boolean[][] visited, int r, int c){

        visited[r][c] = true;
        int ans = 1;
        for( int i = 0 ; i < 4 ; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            int rows = grid.length;
            int cols = grid[0].length;

            if( nr < 0 || nr >= rows || nc < 0 || nc >= cols ){
                continue;
            }
            if( visited[nr][nc] == false && grid[nr][nc] == 1 ){
                ans +=  dfs(grid, visited, nr, nc);
            }
        }
        return ans;
    }

    // Using bfs:
    public static int bfs(int[][] grid, boolean[][] visited, int r, int c){
        int area = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while( q.size() > 0 ){
            int size = q.size();
            for (int i = 0; i < size; i++) {

                // Perform RPA:
                // Remove:
                int[] temp = q.remove();

                // Process:
                int row = temp[0];
                int col = temp[1];
                area++;

                // Add:
                for (int j = 0; j < 4; j++) {
                    int nr = row + dr[j];
                    int nc = col + dc[j];

                    if( nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length ){
                        continue;
                    }
                    if( visited[nr][nc] == false && grid[nr][nc] == 1 ){
                        q.add(new int[]{nr,nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return area;
    }
}
/*
8 13
0 0 1 0 0 0 0 1 0 0 0 0 0
0 0 0 0 0 0 0 1 1 1 0 0 0
0 1 1 0 1 0 0 0 0 0 0 0 0
0 1 0 0 1 1 0 0 1 0 1 0 0
0 1 0 0 1 1 0 0 1 1 1 0 0
0 0 0 0 0 0 0 0 0 0 1 0 0
0 0 0 0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0 0
 */