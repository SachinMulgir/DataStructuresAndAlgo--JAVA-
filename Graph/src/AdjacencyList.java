
import java.util.*;
public class AdjacencyList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[vertices]; //list created that'll store the data of each node

        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges; i++) {
            int curr = sc.nextInt();
            int next = sc.nextInt();
            int weight = sc.nextInt();

            graph[curr].add(new Edge(next, weight));
            graph[next].add(new Edge(curr, weight));

        }

        display(graph);
    }
    public static void display(ArrayList<Edge>[] graph){
        int vertices = graph.length;

        for (int i = 0; i < vertices; i++) {
            System.out.print( i + "->");
            for( Edge e : graph[i] ){
                System.out.print( "(" + e.next + "," + e.weight + ")" );
            }
            System.out.println();
        }

    }
    static class Edge{
        int next;
        int weight;

        Edge(int n, int w){
            this.next = n;
            this.weight = w;
        }
    }


}
/*
5 6
0 1 5
0 2 6
1 2 7
1 3 8
3 4 10
2 4 9
 */