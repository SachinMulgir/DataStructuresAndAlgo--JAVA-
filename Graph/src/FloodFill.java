import java.util.*;
// CAN BE IMPLEMENTED ON GRIDS:
public class FloodFill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println("new pixel data:");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int color = sc.nextInt();

        // Solution:
        grid = floodFill(grid, r, c, color);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " " );
            }
            System.out.println();
        }

    }
    static int[] dr = new int[]{-1,0,1,0};          // for finding adjacent(row wise)
    static int[] dc = new int[]{0,1,0,-1};          // for finding adjacent(column wise)

    public static int[][] floodFill(int[][] grid, int r, int c, int color){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        bfs(grid,visited,r,c,color);
        // dfs(grid,visited,r,c,color);
        return grid;
    }

    // Using DFS:
     public static void dfs(int[][] grid, boolean[][] visited, int r, int c, int color){
        int preVal = grid[r][c];
        visited[r][c] = true;
        grid[r][c] = color;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if( nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length){
                continue;
            }
            if( visited[nr][nc] == false && grid[nr][nc] == preVal){
                dfs(grid,visited,nr,nc,color);
            }
        }
    }

    // Using BFS:
    public static void bfs(int[][] grid,boolean[][] visited, int r, int c, int color){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while( q.size() > 0 ){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // perform RPA
                // Remove
                int[] temp = q.remove();

                // Process:
                int row = temp[0];
                int col = temp[1];
                int preVal = grid[row][col];
                grid[row][col] = color;

                // Add(child/adjacents) :
                for (int j = 0; j < 4; j++) {
                    int nr = row + dr[j];
                    int nc = col + dc[j];

                    if( nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length){
                        continue;
                    }
                    if( visited[nr][nc] == false && grid[nr][nc] == preVal ){
                        q.add(new int[]{nr,nc});
                        visited[nr][nc] = true;
                    }

                }
            }
        }
    }

}
