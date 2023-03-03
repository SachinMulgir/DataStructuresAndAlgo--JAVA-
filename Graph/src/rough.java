import java.util.*;

public class rough {
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        int[] arr1 = new int[edges];
        int[] arr2 = new int[edges];

        //String input:
        String s = sc.next();

        //both array input:
        for (int i = 0; i < edges; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < edges; i++) {
            arr2[i] = sc.nextInt();
        }


        //create graph:
        ArrayList<Integer>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();

        }
        for (int i = 0; i < edges; i++) {
            int u = arr1[i] - 1;
            int v = arr2[i] - 1;

            graph[u].add(v);
        }

        //Solution:
        boolean[] visited = new boolean[vertices];
        boolean[] pathVis = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if( visited[i] == false ){
                Map<Character, Integer> hm = new HashMap<>();
                boolean check = dfs(graph, i, visited, pathVis, hm, s);
                if( !check ){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println("ans :" + max);
    }

    public static boolean dfs(ArrayList<Integer>[] graph, int src, boolean[] visited, boolean[] pathVis, Map<Character, Integer> hm, String s){
        visited[src] = true;
        pathVis[src] = true;

        char ch = s.charAt(src);
        hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        if( hm.get(ch) > max )max = hm.get(ch);

        for( int nbr : graph[src] ){
            if( visited[nbr] && pathVis[nbr] ){
                return false;
            }
            if( !visited[nbr] ){
                boolean check = dfs(graph, nbr, visited, pathVis, hm, s);
                if( check == false )return false;
            }

        }

        visited[src] = false;
        return true;
    }

}
/*
5 4
abaca
1 1 3 4
2 3 4 5



6 6
xyzabc
1 3 2 5 4 6
2 1 3 4 3 4
 */