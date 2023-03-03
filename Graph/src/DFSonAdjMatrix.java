import java.util.*;
public class DFSonAdjMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();

        int[][] graph = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        //solution
        boolean[] visited = new boolean[vertices];
        dfs(0, graph, visited);
    }
    public static void dfs( int src, int[][] graph, boolean[] visited){
        System.out.print(src + " ");
        visited[src] = true;
        for( int nbr = 0 ; nbr < graph.length ; nbr++){
            if( graph[src][nbr] == 1 && visited[nbr] == false ){
                dfs(nbr, graph, visited);
            }
        }
    }
}
