import com.sun.source.tree.ArrayAccessTree;

import java.util.*;
public class Q_SlidingPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[2][3];
        for( int i = 0 ; i < 2 ; i++){
            for (int j = 0; j < 3; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        //solution:
        int ans = slidingPuzzle(grid);
        System.out.println(ans);
    }
    public static int slidingPuzzle(int[][] grid){

        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sb.append(grid[i][j]);
            }
        }

        String initial = sb.toString();
        int[][] swap = new int[][]{{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        visited.add(initial);
        q.add(initial);
        int level = 0;

        while( q.size() > 0 ){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                //remove:
                String temp = q.remove();

                //process:
                //check if it is equal to target (if yes) return level:
                if( temp.equals(target) ) return level;
                //(if not equal) add adjacent:


                //Add:
                int idxZero = -1;
                for (int j = 0; j < temp.length(); j++) {
                    if( temp.charAt(j) == '0' ){
                        idxZero = j;
                        break;
                    }
                }


                int[] currSwap = swap[idxZero];
                for (int j = 0; j < currSwap.length; j++) {
                    int swapIdx = currSwap[j];
                    String swapped = swapChar(temp, idxZero, swapIdx);

                    if( visited.contains(swapped) ){
                        continue;
                    }
                    q.add(swapped);
                    visited.add(swapped);
                }
            }
            level++;
        }
        return -1;
    }
    public static String swapChar(String temp , int i, int j){
        StringBuilder sb = new StringBuilder(temp);               //sb of same value as temp,
        sb.setCharAt(i, temp.charAt(j));
        sb.setCharAt(j, temp.charAt(i));

        return sb.toString();
    }
}
