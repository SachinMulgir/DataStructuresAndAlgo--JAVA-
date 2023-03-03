import java.util.*;
public class DFSofWeightedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        //create graph: array of list of edges connected;
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
        }

        //DFS on weighted graph:
        boolean[] visited = new boolean[vertices];
//        for (int i = 0; i < vertices; i++) {
//            if( visited[i] == false ){
               dfs(0,graph,visited);
//            }
//        }
    }
    public static void dfs(int src, ArrayList<Edge>[] graph, boolean[] visited){
        System.out.print(src + " ");
        visited[src] = true;

        for( Edge e : graph[src] ){
            if( visited[e.v] == false ){
                dfs(e.v, graph, visited);
            }
        }

    }
    static class Edge{
        int v;
        int w;

        Edge(int nbr, int wt){
            this.v = nbr;
            this.w = wt;
        }
    }
}
