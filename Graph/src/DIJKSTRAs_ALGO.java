import java.util.*;
public class DIJKSTRAs_ALGO {
    static class Pair implements Comparable<Pair>{
        int nbr;
        String psf;
        int wsf;

        Pair(int n, String path , int wt){
            this.nbr = n;
            this.psf = path;
            this.wsf = wt;
        }

        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int e = sc.nextInt();     // no. of edges
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            edges.add(list);
        }

        //solution
        // graph creation with list of edges:
        ArrayList<Pair>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for( List<Integer> edge : edges ){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            graph[u].add(new Pair(v,"",w));
            graph[v].add(new Pair(u,"",w));
        }
        System.out.println("Source: ");
        int src = sc.nextInt();

        //Solution

        Dijkstra(graph, src);
    }
    public static void Dijkstra(ArrayList<Pair>[] graph, int src){
        int v = graph.length;
        boolean[] visited = new boolean[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, ""+src , 0));

        while( pq.size() > 0 ){
            //Remove:
            Pair temp = pq.remove();

            //Process:
            if( visited[temp.nbr] == true ){
                continue;
            }
            visited[temp.nbr] = true;
            System.out.println("node: " + temp.nbr + " psf: " + temp.psf + " wsf : " + temp.wsf );

            //Add:
            for( Pair p : graph[temp.nbr] ){
                if( visited[p.nbr] == false ){
                    pq.add(new Pair(p.nbr, temp.psf + p.nbr , temp.wsf + p.wsf ) );
                }
            }

        }
    }
}
/*
7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
 */