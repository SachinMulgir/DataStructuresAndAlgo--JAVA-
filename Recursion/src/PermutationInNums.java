import java.util.*;
public class PermutationInNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> Permutations = permutations(new ArrayList<Integer>(), arr, 0);
        for (int i = 0; i < Permutations.size(); i++) {
            System.out.println(Permutations.get(i));
        }
    }
    public static ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> p , int[] arr, int idx){
        if( idx == arr.length ){
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int element = arr[idx];

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for( int i = 0 ; i <= p.size() ; i++ ){
            ArrayList<Integer> list = new ArrayList<>(p);
            list.add(i,element);
            ans.addAll(permutations(list, arr, idx+1));
        }
        return ans;
    }
}
