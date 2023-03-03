import java.util.*;
public class Q_CycleInUndirectedGraph {
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


        //Solution:
        boolean ans = detectCycle(graph, 0);
        System.out.println(ans);
    }
    public static boolean detectCycle(ArrayList<Integer>[] graph, int src){
        //we can do it using both : DFS && BFS
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if( visited[i] == false ){
//              return dfs(graph,-1, i, visited);
                return bfs(graph, i, visited);
            }
        }
        return false;
    }

    public static boolean dfs( ArrayList<Integer>[] graph,int parent, int src, boolean[] visited){
        visited[src] = true;
        for( int nbr : graph[src] ){
            if( visited[nbr] == false ){
                boolean check = dfs(graph,src,nbr,visited);
                if( check == true )return true;

            }else if( visited[nbr] == true && nbr != parent ){
                return true;
            }
        }
        return false;
    }

    public static boolean bfs(ArrayList<Integer>[] graph,int src, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();

        int[] parent = new int[graph.length];

        q.add(src);
        visited[src] = true;
        parent[src] = -1;

        while( q.size() > 0 ){

            int size = q.size();
            for (int i = 0; i < size; i++) {
                //RPA
                // remove:
                int node = q.remove();

                //perform && add:
                for( int nbr : graph[node] ){
                    if( visited[nbr] == false ){
                        q.add(nbr);
                        visited[nbr] = true;
                        parent[nbr] = node;
                    }
                    else if( visited[nbr] == true && nbr != parent[node] ){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
