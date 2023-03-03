import java.util.*;
public class Q_ShortestPathWithUnitDistance {
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

        //solution
        int[] ans = shortestPathUnitDistance(graph,0);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] shortestPathUnitDistance(ArrayList<Integer>[] graph, int src){
        int vertices = graph.length;
        int[] ans = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;
        int level = 0;

        while( q.size() > 0 ){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                //Perform RPA:
                //remove:
                int node = q.remove();

                //process:
                ans[node] = level;

                //add:
                for( int nbr : graph[node] ){
                    if( visited[nbr] == false ){
                        q.add(nbr);
                        visited[nbr] = true;
                    }
                }
            }
            level++;
        }
        return ans;
    }
}
/*
vertices, edges
9 10

edges:
0 1
0 3
3 4
4 5
5 6
1 2
2 6
6 7
7 8
6 8

Process finished with exit code 0

 */