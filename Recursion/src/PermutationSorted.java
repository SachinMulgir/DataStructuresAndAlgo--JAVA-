import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PermutationSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean[] freq = new boolean[n];
        ArrayList<ArrayList<Integer>> ans = permutations(new ArrayList<Integer>(), arr, freq );
        System.out.println(ans);
    }
    public static ArrayList<ArrayList<Integer>> permutations( ArrayList<Integer> p , int[] arr, boolean[] freq){
        if( p.size() == arr.length ){
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            if( !freq[i] ){
                if(i < arr.length - 1 && arr[i] == arr[i+1]){
                    freq[i+1] = true;
                }
                freq[i] = true;
                ArrayList<Integer> temp = new ArrayList<>(p);
                temp.add(arr[i]);
                ans.addAll( permutations(temp, arr, freq) );
                freq[i] = false;
                if( i < arr.length - 1 && arr[i] == arr[i+1] ){
                    freq[i+1] = true;
                }
            }
        }
       return ans;
    }
}
