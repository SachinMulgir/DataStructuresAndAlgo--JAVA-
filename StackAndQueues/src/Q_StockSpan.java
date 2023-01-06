import java.util.*;
public class Q_StockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        int ans[] = stockSpan(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] stockSpan(int[] arr){
        int[] span = new int[arr.length];
        Stack<Integer> st = new Stack<>();
//        st.push(0);
//        span[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            int price = arr[i];
            while( st.size() > 0 && arr[ st.peek() ] <= price ){
                st.pop();
            }
            if( st.size() == 0 ){
                span[i] = i + 1;
            }else{
                span[i] = i - st.peek();
            }
            st.push(i);
        }
        return span;
    }

}
