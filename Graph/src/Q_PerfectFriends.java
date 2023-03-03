import java.util.*;
public class Q_PerfectFriends {
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
            graph[v].add(u);
        }

        //Solution:
        int ans = perfectFriends(graph,vertices);
        System.out.println(ans);
    }
    public static int perfectFriends(ArrayList<Integer>[] graph, int v){
        // first get all the components with the data.
        List<List<Integer>> clubs = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if( visited[i] == false ) {
                List<Integer> component = new ArrayList<>();
                dfs(graph, visited, i, component);
                clubs.add(component);
            }
        }

        int pairs = 0;
        for (int i = 0; i < clubs.size(); i++) {
            for (int j = i+1; j < clubs.size(); j++) {
                pairs += clubs.get(i).size() * clubs.get(j).size();
            }
        }
        return pairs;
    }
    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int src, List<Integer> component){
        visited[src] = true;
        component.add(src);

        for( int nbr : graph[src] ){
            if( visited[nbr] == false ){
                dfs(graph, visited, nbr, component);
            }
        }
    }
}
