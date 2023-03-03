import java.util.*;
public class Q_NetworkDelayTime {
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
        System.out.println("source: ");
        int k = sc.nextInt();

        //solution
        // graph creation with list of edges:
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for( List<Integer> edge : edges ){
            int u = edge.get(0) - 1;
            int v = edge.get(1) - 1;
            int w = edge.get(2);

            graph[u].add(new Edge(v,w));          //directed
        }

        //Solution:
        int ans = networkDelay(vertices, graph, k);
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
    public static int networkDelay(int v, ArrayList<Edge>[] graph, int k){
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(k-1,0));              // k-1 because it has 1 based indexing

        int[] time = new int[v];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k-1] = 0;

        boolean[] visited = new boolean[v];

        while( q.size() > 0 ){
            //remove:
            Pair temp = q.remove();

            //process:
            int curr = temp.v;
            int currTime = temp.w;

            if( visited[curr] )continue;
            visited[curr] = true;

            //Add:
            for( Edge e : graph[curr] ){
                int nbr = e.v;
                int nbrTime = e.w;
                if( time[nbr] > currTime + nbrTime ){
                    time[nbr] = currTime + nbrTime;
                    q.add(new Pair( nbr, time[nbr]));
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < v; i++) {
            if( time[i] > ans )ans = time[i];
        }

        if( ans == Integer.MAX_VALUE )return -1;
        return ans;
    }
}
