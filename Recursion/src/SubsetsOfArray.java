import java.lang.reflect.Array;
import java.util.*;
public class SubsetsOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        // subsets of array
        ArrayList<ArrayList<Integer>> ans = subsets(new ArrayList<Integer>(), arr, 0);
        for( int i = 0 ; i < ans.size() ; i++){
            System.out.println(ans.get(i));
        }

    }
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> p , int[] arr,  int idx){
        if( idx == arr.length ){
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        int element = arr[idx];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        //don't keep the element
        ans.addAll(subsets( p,arr, idx+1));
        //keep the elements:
        ArrayList<Integer> list = new ArrayList<>(p);
        list.add(element);
        ans.addAll(subsets(list, arr, idx+1));
        return ans;
    }
}
