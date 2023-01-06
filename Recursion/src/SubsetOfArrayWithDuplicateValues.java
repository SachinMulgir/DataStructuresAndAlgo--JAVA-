import java.util.*;
public class SubsetOfArrayWithDuplicateValues {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        //subsets of array with duplicate values
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            if( i>0 && arr[i] == arr[i-1] ){
                start = end + 1;
            }
            end = outer.size()-1;

            for( int j = start ; j <= end ; j++){
                ArrayList<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }

        //Printing ans
        for (int i = 0; i < outer.size(); i++) {
            System.out.println(outer.get(i));
        }
    }
}
