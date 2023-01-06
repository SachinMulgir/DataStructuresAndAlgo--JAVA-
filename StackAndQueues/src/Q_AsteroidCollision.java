import java.util.*;
public class Q_AsteroidCollision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = asteroidCollision(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack();
        for( int i = 0 ; i < asteroids.length ; i++){
            int val = asteroids[i];

            // if value is positive keep adding it to the stack :
            if( val > 0 ){                      //given val != 0;
                st.push(val);
            }
            else{
                // all smaller values in opposite direction will get popped:

                while( st.size() > 0 && st.peek() > 0 && st.peek() < -val) {
                    st.pop();
                }

                // if st.peek() == -val, they both will pop....so only ONE POP in stack-> move to next
                // iteration.

                if( st.size() > 0 && st.peek() == -val){
                    st.pop();
                }

                // if size == 0 OR already -ve value on top -> push the value in stack:
                else if( st.size() == 0 || st.peek() < 0 ){
                    st.push(val);
                }
            }
        }

        int size = st.size();
        int[] ans = new int[size];
        for ( int i = size - 1 ; i >= 0 ; i--){
            ans[i] = st.pop();
        }

        return ans;
    }
}
