import java.util.*;

public class Q_CountComponents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();

        int[][] graph = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // solution
        boolean[] visited = new boolean[vertices];
        int count = 0;
        for (int i = 0; i < vertices; i++) {
            if( visited[i] == false ){
                bfs(i,graph, visited);
                //dfs(i,graph, visited);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void bfs( int src, int[][] graph, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;

        while( q.size() > 0 ){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.remove();
                for (int nbr = 0; nbr < graph.length; nbr++) {
                    if( graph[node][nbr] == 1 && visited[nbr] == false ){
                        q.add(nbr);
                        visited[nbr] = true;
                    }
                }
            }
        }
    }

    public static void dfs( int src, int[][] graph, boolean[] visited){
        visited[src] = true;
        for( int nbr = 0 ; nbr < graph.length ; nbr++){
            if( graph[src][nbr] == 1 && visited[nbr] == false ){
                dfs(nbr, graph, visited);
            }
        }
    }
}
/*
3
1 1 0
1 1 0
0 0 1

ans = 2
 */