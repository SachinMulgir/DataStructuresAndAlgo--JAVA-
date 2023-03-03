import java.util.*;
public class BFS {
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


        //BFS
        printBFS(graph);
    }
    public static void printBFS(ArrayList<Integer>[] graph){
        // create a queue to store nodes of each level
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        q.add(0);
        visited[0] = true;

        //run till the queue is empty:
        while( q.size() > 0 ){

            int size = q.size();                     //size of each level
            for (int i = 0; i < size; i++) {

                //perform RPA : (remove, process, add)
                //remove
                int node = q.remove();

                //print
                System.out.print(node + " ");

                //add: add all neighbours to the queue for next level
                for( int nbr : graph[node] ){
                    if( visited[nbr] == false ){
                        q.add(nbr);
                        visited[nbr] = true;              // once added to queue -> mark it visited
                    }
                }
            }
        }
    }
}
/*
vertices, edges:
5 4
edges:
0 1
1 2
2 3
3 4

o/p : 0 1 2 3
 */