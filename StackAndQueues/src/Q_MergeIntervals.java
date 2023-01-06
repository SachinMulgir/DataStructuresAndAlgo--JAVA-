import java.util.*;
// PAIR CLASS IS USED TO TAKE ELEMENTS AS PAIRS IN STACK:
// WE USED COMPARABLE INTERFACE TO SORT THE PAIR CLASS OBJECTS;
class Pair implements Comparable<Pair>{
    int start ;
    int end ;

    public Pair(int s, int e){
        this.start = s;
        this.end = e;
    }
    public int compareTo(Pair other){
        if( this.start != other.start ){
            return this.start - other.start;
        }
        else{
            return this.end - other.end;
        }
    }
}
public class Q_MergeIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] ans = mergeInterval(arr);
        System.out.println("\nfinal answer:");
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }

    public static int[][] mergeInterval(int[][] arr){
        Stack<Pair> st = new Stack<>();
        Pair[] pairs = new Pair[arr.length];

        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0] , arr[i][1]);
        }

        // sort the pairs array before comparing:
        Arrays.sort(pairs);

        for (int i = 0; i < pairs.length; i++) {
            Pair current = pairs[i];
            if( i == 0 ){
                st.push(current);
            }else{
                Pair top = st.peek();
                if( top.end >= current.start ){
                    //merge :
                    top.end = Math.max(current.end, top.end);
                }else{
                    //directly add :
                    st.push(current);
                }
            }
        }

        // copy the stack into another to get the value aligned..
        // since they're oppositely aligned in current stack
        Stack<Pair> st2 = new Stack<>();
        while( st.size() > 0 ){
            st2.push(st.pop());
        }

        int[][] ans = new int[st2.size()][2];

        int size = st2.size();  //take size in variable coz it'll change with pop() in each iteration

        for (int i = 0; i < size; i++) {
            Pair p = st2.pop();
            ans[i][0] = p.start;
            ans[i][1] = p.end;
        }
        return ans;
    }
}

// 6 22 28 1 8 25 27 14 19 27 30 5 12
