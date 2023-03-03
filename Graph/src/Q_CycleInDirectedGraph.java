import java.util.*;
// it is considered a cycle when: the nbr is present already in our path.

public class Q_CycleInDirectedGraph {
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
        // graph creation with list of edges:
        ArrayList<Integer>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for( List<Integer> edge : edges ){
            int u = edge.get(0);
            int v = edge.get(1);

            graph[u].add(v);
//          graph[v].add(u);                //SINCE it is a directed graph: we'll not assign it backward
        }


        //solution
        boolean ans = detectCycle(graph);
        System.out.println(ans);
    }
    public static boolean detectCycle(ArrayList<Integer>[] graph){
        boolean[] visited = new boolean[graph.length];
        boolean[] path = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if( visited[i] == false ){
                boolean check = dfs(graph,i,visited, path);
                if( check == true )return true;
            }
        }
        return false;
    }

    public static boolean dfs(ArrayList<Integer>[] graph, int src, boolean[] visited, boolean[] path){
        visited[src] = true;
        path[src] = true;
        for( int nbr : graph[src] ){
            if( visited[nbr] == false ){
                boolean check = dfs(graph , nbr, visited, path);
                if( check == true )return true;
            }else if ( visited[nbr] == true && path[nbr] == true){
                return true;
            }
        }
        path[src] = false;
        return false;
    }
}
