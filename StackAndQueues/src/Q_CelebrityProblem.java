import java.util.*;
public class Q_CelebrityProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = celeb(arr, n);
        System.out.println(ans);
    }
    public static int celeb(int[][] arr, int n){
        //stack to store the no. of guest:
        Stack<Integer> st = new Stack<>();

        //add the guest into the stack:
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        //elimination method to pin down a single value which has the highest probability of being a celeb

        while( st.size() > 1 ){
            int v2 = st.pop();
            int v1 = st.pop();

            if( arr[v1][v2] == 0 ){
                st.push(v1);
            }else{
                st.push(v2);
            }
        }
        int val = st.pop();


        // 1. all the element in the value row => 0 :
        // 2. all the elements int the value column => 1 ( EXCEPT DIAGONAL VALUE where i == j )

        for (int i = 0; i < n; i++) {
            // only check non diagonal cells:
            if( val != i ){
                if(  arr[i][val] != 0 || arr[val][i] != 1){
                    return -1;
                }
            }
        }

        return val;
    }
}
