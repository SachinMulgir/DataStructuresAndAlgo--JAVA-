import java.util.*;
public class Q_CheckBipartite {
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

            graph[u-1].add(v-1);
            graph[v-1].add(u-1);
        }

        //solution
        boolean ans = bipartite(graph);
        System.out.println(ans);
    }
    public static boolean bipartite(ArrayList<Integer>[] graph){

        Queue<Integer> q = new LinkedList<>();

        int vertices = graph.length;
        boolean[] visited = new boolean[vertices];
        int[] color = new int[vertices];

        q.add(0);
        visited[0] = true;
        color[0] = 1;

        while( q.size() > 0 ){
            int size = q.size();
            for (int i = 0; i < size; i++) {

                //RPA:
                //remove:
                int src = q.remove();

                //process && add :
                for( int nbr : graph[src] ){
                    if( visited[nbr] == false ){
                        q.add(nbr);
                        visited[nbr] = true;
                        if( color[src] == 1 )color[nbr] = 0;
                        else color[nbr] = 1;
                    }
                    else{
                        if( color[nbr] == color[src] )return false;
                    }
                }
            }
        }
        return true;
    }
}
