import java.util.*;
public class Q_NoOfWaysToArriveAtDestination {
    static class Edge{
        int v;
        int w;

        public Edge(int v, int w){
            this.v = v;
            this.w = w;
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
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for( List<Integer> edge : edges ){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
        }

        //
        int ans = countPath(vertices, graph);
        System.out.println(ans);
    }
    static class Pair implements Comparable<Pair>{
        int v;
        int w;

        public Pair(int v, int w){
           this.v = v;
           this.w = w;
        }
        public int compareTo(Pair other){
            return this.w - other.w;
        }
    }
    public static int countPath(int v, ArrayList<Edge>[] graph){
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        int[] ways = new int[v];
        ways[0] = 1;

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0,0));

        boolean[] visited = new boolean[v];

        while( q.size() > 0 ){
            //Remove:
            Pair temp = q.remove();

            //Process:
            int curr = temp.v;
            int currWt = temp.w;
            if( visited[curr] == true )continue;
            visited[curr] = true;

            //Add:
            for( Edge e : graph[curr] ){
                int nbr = e.v;
                int nbrWt = e.w;
                if( distance[nbr] > currWt + nbrWt){
                    distance[nbr] = currWt + nbrWt;
                    ways[nbr] = ways[curr];
                    q.add(new Pair(nbr, distance[nbr]));
                }
                else if( distance[nbr] == currWt + nbrWt ){
                    ways[nbr] += ways[curr];
                }
            }

        }
        return ways[v-1];

    }
}
/*
9
13
0 1 1
0 2 2
0 3 1
0 4 2
1 5 2
2 5 1
3 5 2
4 6 1
3 7 3
3 6 2
5 8 1
7 8 1
6 8 1

ans = 5;
 */