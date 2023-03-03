import java.util.*;
public class Q_JumpGame4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // jump game IV: //leetcode 1345
        int ans = minJumps(arr);
        System.out.println(ans);
    }
    public static int minJumps(int[] arr){
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();

        // create a hashmap for <value, list of indices> :
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for( int i = 0 ; i < n ; i++ ){
            int num = arr[i];
            if( hm.containsKey(num) ){
                List<Integer> old = hm.get(num);
                old.add(i);
                hm.put(num, old);
            }
            else{
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                hm.put(num,newList);
            }
        }

        boolean[] visited = new boolean[n];

        q.add(0);
        visited[0] = true;
        int level = 0;

        while( q.size() > 0 ){
            int size = q.size();
            for (int i = 0; i < size; i++) {

                //RPA:
                //Remove:
                int temp = q.remove();

                //Process (look for condition):
                if ( temp == n -1 )return level;

                // Add (all 3 possibilities):
                // 1. (i + 1)
                if( temp < n-1 ){
                    int next = temp + 1;
                    if( visited[next] == false ){
                        q.add(next);
                        visited[next] = true;
                    }
                }

                // 2. (i - 1)
                if( temp > 0 ){
                    int prev = temp - 1;
                    if( visited[prev] == false ){
                        q.add(prev);
                        visited[prev] = true;
                    }
                }

                // 3. j(duplicates):
                List<Integer> list = hm.get(arr[temp]);
                for (int j = 0; j < list.size(); j++) {
                    int idx = list.get(j);
                    if( visited[idx] == false ){
                        q.add(idx);
                        visited[idx] = true;
                    }
                }
                hm.put(arr[temp] , new ArrayList<>());
            }
            level++;
        }
        return -1;

    }
}
/*
10
100 -23 -23 404 100 23 23 23 3 404
 */