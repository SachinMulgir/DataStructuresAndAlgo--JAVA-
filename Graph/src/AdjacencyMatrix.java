import java.util.*;
public class AdjacencyMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        // declare Adjacency Matrix:
        int[][] graph = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u][v] = 1;
            graph[v][u] = 1;       // undirected
        }

    }
}
