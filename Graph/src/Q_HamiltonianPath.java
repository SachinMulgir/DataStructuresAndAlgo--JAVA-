import java.util.*;
public class Q_HamiltonianPath {
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
//        System.out.println("from: ");
//        int l = sc.nextInt();
//        System.out.println("to");
//        int h = sc.nextInt();

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
        boolean[] visited = new boolean[vertices];
        boolean ans = false;
        for (int i = 0; i < vertices; i++) {
            ans = hamiltonian(graph, i, vertices-1, visited, 1);
            if(ans == true )break;
        }

        System.out.println(ans);
    }
    public static boolean hamiltonian(ArrayList<Integer>[] graph, int src, int des, boolean[] visited,int count){
        if( count == graph.length ){
            return true;
        }
        visited[src] = true;
        for( int nbr : graph[src] ){
            if( visited[nbr] == false ){
                boolean ans = hamiltonian(graph,nbr, des, visited,count+1);
                if( ans == true )return true;
            }
        }
        visited[src] = false;
        return false;
    }
}
