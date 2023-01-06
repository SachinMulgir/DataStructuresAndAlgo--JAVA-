import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q_NextGreaterElementToRight_part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        int[] ans = nextGreaterPart2(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] nextGreaterPart2(int[] arr){
        int[] nGe = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            while( st.size() > 0 && arr[st.peek()] <= element ){
                int index = st.peek();
                nGe[ index ] = element;
                st.pop();
            }
            st.push(i);
        }
        while( st.size() > 0 ){
            int index = st.peek();
            nGe[index] = -1;
            st.pop();
        }
        return nGe;
    }
}
