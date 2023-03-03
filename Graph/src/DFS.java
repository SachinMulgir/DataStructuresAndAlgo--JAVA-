import java.util.*;
public class DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int e = sc.nextInt();     // no. of edges
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            edges.add(list);
        }

        //solution
        // graph creation with list of edges:
        ArrayList<Integer>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for( List<Integer> edge : edges ){
            int u = edge.get(0);
            int v = edge.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        //call DEPTH FIRST SEARCH on the graph:
        // we'll do it inside the loop so that if there are disconnected graph, they'll also get covered:

        boolean[] visited = new boolean[vertices]; // array to mark visited or not;

        for (int i = 0; i < vertices; i++) {
            if(visited[i] == false){
                dfs(i, graph, visited);
            }
        }
    }
    public static void dfs(int curr, ArrayList<Integer>[] graph, boolean[] visited){
        System.out.print( curr + " " );
        visited[curr] = true;
        Collections.sort(graph[curr]);     // reach the graph nodes in accessible sorted manner

        for( int base : graph[curr] ){
            if( visited[base] == false ){
                dfs(base, graph, visited);
            }
        }
    }
}
/*
// vertices &&  edges
4 4

// edges without weight;
1 3
0 2
2 3
1 2


 */
