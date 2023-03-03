import java.util.*;
public class Q_PrintPaths {
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
        System.out.println("from: ");
        int l = sc.nextInt();
        System.out.println("to");
        int h = sc.nextInt();

        // graph creation with list of edges:
        ArrayList<Integer>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for( List<Integer> edge : edges ){
            int u = edge.get(0);
            int v = edge.get(1);

            graph[u].add(v);
        }

        // Solution:
        printPath(graph, l, h);
    }
    public static void printPath(ArrayList<Integer>[] graph , int l ,int h){
        boolean[] visited = new boolean[graph.length];

        System.out.println("lists:");
        paths(new ArrayList<Integer>(), graph ,l, h,visited);

        System.out.println("\n\nStrings:");
        pathsString("",graph,l,h, visited);
    }
    public static void paths(ArrayList<Integer> p ,ArrayList<Integer>[] graph, int src, int des,boolean[] visited){
        if( src == des ){
            p.add(src);
            System.out.println(p);
            return;
        }
        visited[src] = true;
        ArrayList<Integer> temp = new ArrayList<>(p);
        temp.add(src);
        for( int num : graph[src] ){
            if( visited[num] == false){
                paths(temp,graph,num,des,visited);
            }
        }
        visited[src] = false;
    }

    public static void pathsString(String p, ArrayList<Integer>[] graph,int src, int des, boolean[] visited){
        if( src == des ){
            p = p + src;
            System.out.println(p);
            return ;
        }
        visited[src] = true;
        for( int nbr : graph[src] ){
            if( visited[nbr] == false ){
                pathsString(p+src,graph,nbr,des,visited);
            }
        }
        visited[src] = false;
    }
}
/*
vertices,edge
7 8

edges:
0 1
1 2
2 3
0 3
3 4
4 5
5 6
4 6

from to:
0 6
 */