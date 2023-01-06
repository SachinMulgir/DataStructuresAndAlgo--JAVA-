import java.util.*;
public class Q_SumOfSubarrayMinimum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(subarrayMinSum(arr));
    }
    public static int[] nextSmallerLeftIdx(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1 ; i >= 0 ; i--) {          // to iterate backward for left extension
            int element = arr[i];
            if( st.size() == 0 ){
                st.push(i);
            }else{
                while( st.size() > 0 && arr[st.peek()] > element ){
                    int index = st.peek();
                    ans[ index ] = i;
                    st.pop();
                }
                st.push(i);
            }
        }
        while( st.size() > 0 ){
            int index = st.peek();
            ans[index] = -1;
            st.pop();
        }
        return ans;
    }
    public static int[] nextSmallerRightIdx(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if( st.size() == 0 ){
                st.push(i);
            }else{
                while( st.size() > 0 && arr[st.peek()] >= element ){
                    int index = st.peek();
                    ans[ index ] = i;
                    st.pop();
                }
                st.push(i);
            }
        }
        while( st.size() > 0 ){
            int index = st.peek();
            ans[index] = arr.length;
            st.pop();
        }
        return ans;
    }
    public static long subarrayMinSum(int[] arr){
        int[] nsL = nextSmallerLeftIdx(arr);              // get the nsL[] for left extension
        int[] nsR = nextSmallerRightIdx(arr);             // get the nsR[] for right extension
        long ans = 0;

        // in question it is given that : we need to find modulo of ans to (10 ^ 9) + 7
        // formula for calculating modulo
        // (a + b) : ( ( a % M ) + ( b % M ) ) % M;      =>   ( ( a modulo + b modulo ) whole modulo)
        long M = 1000000007;
        for (int i = 0; i < arr.length; i++) {

            long num = (long)( i - nsL[i] ) * (long)( nsR[i] - i );
            long temp = ( ( arr[i] % M ) * ( num % M ) ) % M;
            ans = ( ( ans % M ) + ( temp % M ) ) % M;

        }
        return ans;
    }
}
// 8
// 2 9 7 8 3 4 6 1
