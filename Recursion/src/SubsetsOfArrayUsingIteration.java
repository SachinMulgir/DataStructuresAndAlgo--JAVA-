import java.util.*;
public class SubsetsOfArrayUsingIteration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        //subsets using Iteration
        ArrayList<ArrayList<Integer>> ans = subsetsUsingIteration(arr);
        //printing output
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }

    }
    public static ArrayList<ArrayList<Integer>> subsetsUsingIteration(int[] arr){
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add( new ArrayList<>());
        for( int num : arr){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }
}
