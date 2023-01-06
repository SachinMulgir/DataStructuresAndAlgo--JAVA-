import java.util.*;
public class Q_SmallestNumFollowingSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        smallestNum(s);
    }
    public static void smallestNum(String s){
        Stack<Integer> st = new Stack<>();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if( ch == 'd' ){
                count++;
                st.push(count);
            }else{
                count++;
                st.push(count);
                while( st.size() > 0 ){
                    System.out.print(st.pop());
                }
            }
        }
        count++;
        st.push(count);
        while( st.size() > 0 ){
            System.out.print(st.pop() );
        }
    }
}
