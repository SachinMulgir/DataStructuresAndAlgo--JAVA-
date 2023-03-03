import java.util.*;
public class Q_3Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //Solution:
        //Approach 1: using 2 pointers -   Complexity - O(N)
        ArrayList<ArrayList<Integer>> ans = ThreeSum(arr);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
    public static ArrayList<ArrayList<Integer>> ThreeSum(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if( i > 0 ){
                while( arr[i-1] == arr[i] && i < n-1 )i++;
                if( i > n - 1 )return ans;
            }
            int a = arr[i];
            int s = i + 1;
            int e = n - 1;
            int target = 0 - a;

            while( s < e ){
                int sum = arr[s] + arr[e];
                if( sum < target ){
                    do{
                        if( s < n - 1 ) s++;
                    }while(arr[s - 1] == arr[s]);
                }
                else if( sum > target ){
                    do{
                        if( e > 0 )e--;
                    }while( arr[e+1] == arr[e]);
                }
                else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[s]);
                    list.add(arr[e]);
                    ans.add(list);
                    do{
                        if( s < n - 1 ) s++;
                    }while(arr[s - 1] == arr[s]);
                    do{
                        if( e > 0 )e--;
                    }while( arr[e+1] == arr[e]);
                }
            }
        }
        return ans;
    }
}
/*
11
-2 -2 -1 -1 -1 0 0 0 2 2 2
 */