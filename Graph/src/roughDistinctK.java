import java.util.*;
public class roughDistinctK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = helpaterp(arr);
        System.out.println(ans);
    }

    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};

    public static int helpaterp(int[][] hospital) {

        int uninfected = 0;
        int rows = hospital.length;
        int cols = hospital[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val = hospital[i][j];
                if (val == 1) uninfected++;
                if (val == 2) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int time = 0;

        while (q.size() > 0) {
            int size = 0;
            for (int i = 0; i < size; i++) {
                //Remove:
                int[] temp = q.remove();

                //Process:
                int r = temp[0];
                int c = temp[1];
                if (uninfected == 0) return time;

                //Add:
                for (int j = 0; j < 4; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) {
                        continue;
                    }
                    if (visited[nr][nc] == false && hospital[nr][nc] == 1) {
                        uninfected--;
                        hospital[nr][nc] = 2;
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }

                }
            }
            time++;
        }
        if (uninfected == 0) return time;
        return -1;
    }
}
//    public static int getDistinctCount(int[] arr, int k){
//        int start = 0;
//        int end = 0;
//        Map<Integer, Integer> hm = new HashMap<>();
//        int distinct = 0;
//        int count = 0;
//
//        while( end < arr.length ){
//
//            //1. expansion:
//            int numEnd = arr[end];
//            hm.put( numEnd, hm.getOrDefault(numEnd, 0) + 1);
//            if( hm.get( numEnd ) == 1 )distinct++;
//            end++;
//
//            //2. contraction:
//            while( start < end && distinct > k ){
//                int numStart = arr[start];
//                hm.put( numStart, hm.get(numStart) - 1);
//                if( hm.get(numStart) == 0 )distinct--;
//                start++;
//            }
//
//            //3. calculation:
//            count += end - start;
//        }
//        return count;
//    }

