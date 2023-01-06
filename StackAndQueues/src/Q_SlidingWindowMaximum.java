import java.util.*;
public class Q_SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("window size : ");
        int k = sc.nextInt();
        System.out.println(Arrays.toString(arr));
        System.out.println("\n"+Arrays.toString(slidingWindowMax(arr,k)));
    }
    public static int[] slidingWindowMax(int[] arr, int k){

        int[] ans = new int[ arr.length - k + 1];

        // 1. Create an array to store the next greater element on right for the array:
        //    (ONLY STORE THE INDICES)

        int[] nGE = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if( st.size() == 0 ){
                st.push(i);
            }else{
                while( st.size() > 0 && arr[ st.peek() ] < element ){
                    int index = st.peek();
                    nGE[index] = i;
                    st.pop();
                }
                st.push(i);
            }
        }
        while( st.size() > 0 ){
            int index = st.peek();
            nGE[index] = arr.length;
            st.pop();
        }

        // 2. Run a for loop to iterate through the array and slide the window accordingly

        int j = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            if( j < i ){
                j = i ;
            }
            while( nGE[j] < i + k ){
                j = nGE[j];
            }
            ans[i] = arr[j];
        }

        return ans;
    }
}
