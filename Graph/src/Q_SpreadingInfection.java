import java.util.*;
public class Q_SpreadingInfection {
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

            int src = sc.nextInt();
            int time = sc.nextInt();

            //solution:
            int infected = getInfected(graph,src,time);
            System.out.println(infected);
    }
    public static int getInfected(ArrayList<Integer>[] graph, int src , int time){
            int v = graph.length;
            boolean[] visited = new boolean[v];
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            visited[src] = true;
            int infected = 0;

            while( q.size() > 0 ){
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    //remove:
                    int temp = q.remove();

                    //process:
                    if( time == 0 )return infected;
                    infected++;

                    //Add:
                    for( int nbr : graph[temp] ){
                        if( visited[nbr] == false ){
                            visited[nbr] = true;
                            q.add(nbr);
                        }
                    }
                }
                time--;
            }
            return infected;
    }
}
/*
7
8
0 1
1 2
2 3
0 3
3 4
4 5
5 6
4 6
6
3

ans = 4;
 */