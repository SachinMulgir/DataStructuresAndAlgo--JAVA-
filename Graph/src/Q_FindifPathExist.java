import java.util.*;
public class Q_FindifPathExist {
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

        System.out.println("src & des :");
        int src = sc.nextInt();
        int des = sc.nextInt();

        // graph creation with list of edges:  BI-DIRECTIONAL
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


        // Solution :
        boolean[] visited = new boolean[vertices];
        System.out.println(ifPathExist(graph, src, des, visited));

    }
    public static boolean ifPathExist(ArrayList<Integer>[] graph, int src, int des, boolean[] visited){

        if( src == des ){
            return true;
        }
        visited[src] = true;
        for( int edge : graph[src] ){
            if( visited[edge] == false ){
                boolean check = ifPathExist(graph, edge, des, visited);
                if( check == true )return true;
            }
        }
        return false;
    }
}
/*
vertices, edges =
10, 10
edges =
[[4,3],[1,4],[4,8],[1,7],[6,4],[4,2],[7,4],[4,0],[0,9],[5,4]]
source =
5
destination =
9

o/p = true;
 */