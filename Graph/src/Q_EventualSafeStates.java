import java.util.*;
public class Q_EventualSafeStates {
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
        }

        //Solution:
        boolean[] visited = new boolean[vertices];
        boolean[] pathVis = new boolean[vertices];
        boolean[] check = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if( visited[i] == false ){
                boolean chk = ( dfs(graph, i, visited, pathVis, check ) );
                if( chk == false ){
                    continue;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if( check[i] == true )ans.add(i);
        }
        System.out.println(ans);
    }
    public static boolean dfs( ArrayList<Integer>[] graph, int src, boolean[] visited, boolean[] pathVis, boolean[] check){
        visited[src] = true;
        pathVis[src] = true;

        for( int nbr : graph[src] ){
            if( visited[nbr] == false ){
                boolean chk = dfs(graph, nbr, visited, pathVis, check);
                if( chk == false ) {
                    return false;
                }
            }
            else{
                if( pathVis[nbr] == true ){
                    return false;
                }
            }
        }
        check[src] = true;
        pathVis[src] = false;
        return true;
    }

}

/*
12
13
0 1
1 2
2 3
3 4
3 5
4 6
5 6
6 7
8 1
8 9
9 10
10 8
11 9
 */