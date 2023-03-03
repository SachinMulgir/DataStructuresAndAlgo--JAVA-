import java.util.*;
public class Q_PathBetweenTwoVertices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vertices,edges:");
        int vertices = sc.nextInt();
        int e = sc.nextInt();     // no. of edges
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            edges.add(list);
        }
        System.out.println("from: ");
        int src = sc.nextInt();
        System.out.println("to");
        int tar = sc.nextInt();

        // graph creation with list of edges: UNDIRECTED
        ArrayList<Integer>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for( List<Integer> edge : edges ){
            int u = edge.get(0);
            int v = edge.get(1);

            graph[u].add(v);
            graph[v].add(u);            // UNDIRECTED
        }

        //array to check the visited nodes:
        boolean[] visited = new boolean[vertices];
        //solution
        System.out.println(path(graph, src, tar,visited));
    }
    public static boolean path(ArrayList<Integer>[] graph, int src, int tar, boolean[] visited){
        if( src == tar ){
            return true;
        }
        visited[src] = true;
        for( int num : graph[src] ){
            if( visited[num] == false ){
                return path(graph,num,tar,visited);
            }
        }
        return false;
    }
}
