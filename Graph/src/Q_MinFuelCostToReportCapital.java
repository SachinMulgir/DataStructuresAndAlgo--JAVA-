import java.util.*;
public class Q_MinFuelCostToReportCapital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n-1][2];
        for (int i = 0; i < n - 1; i++) {
            grid[i][0] = sc.nextInt();
            grid[i][1] = sc.nextInt();
        }

        int seats = sc.nextInt();


        //Graph:
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int u = grid[i][0];
            int v = grid[i][1];

            graph[u].add(v);
            graph[v].add(u);                            // undirected graph.
        }

        //solution:
        boolean[] visited = new boolean[n];
        //long ans = getMinFuelCost(graph, n, seats);
        long ans = dfs(0, graph, visited, 1, 1, seats);
        System.out.println(ans);
    }
    public static long getMinFuelCost(ArrayList<Integer>[] graph, int n, int seats){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,1,0});                       // < node, passenger, car >

        boolean[] visited = new boolean[n];

         long ans = 0;

         while( q.size() > 0 ){
             int size = q.size();
             for (int i = 0; i < size; i++) {
                 //Remove:
                 int[] temp = q.remove();

                 //Process:
                 int curr = temp[0];
                 int passenger = temp[1];
                 int car = temp[2];

                 if( visited[curr] == true )continue;
                 visited[curr] = true;

                 ans += car;
//                 System.out.println("curr:" + curr + " passenger: " + passenger + " car: "+ car + " ans : "+ ans);

                 //Add:
                 for( int nbr : graph[curr] ){
                     System.out.println("curr:" + curr + " nbr: "+ nbr + " passenger: " + passenger + " car: "+ car + " ans : "+ ans);
                     passenger++;
                     if( passenger > seats ){
                         passenger = 1;
                         car++;
                     }
                     q.add(new int[]{nbr, passenger, car});
                 }
             }
         }
         return ans;
    }

    public static long dfs(int src, ArrayList<Integer>[] graph, boolean[] visited, int passenger, int car, int seats){
        visited[src] = true;
        long ans = 0;
        for( int nbr : graph[src] ){
            if( visited[nbr] == false ){
                if( car > seats ){
                    car++;
                }
                ans = dfs(nbr, graph, visited, passenger+1, car, seats);
            }
        }
        return ans + car;
    }
}
/*
11
0 1
1 2
2 3
3 4
0 5
5 6
6 7
5 8
8 9
9 10
3
 */