import java.util.*;

public class Q_NextGreaterElementToRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(ngetr(arr)));
    }
    public static int[] ngetr(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for( int i = arr.length-1 ; i >= 0 ; i--){
            int element = arr[i];
            if( st.size() == 0 ){
                st.push(element);
                ans[i] = -1;
            }else{
                while( st.peek() <= element ){
                    st.pop();
                }
                ans[i] = st.peek();
                st.push(element);
            }
        }
        return ans;
    }
}
