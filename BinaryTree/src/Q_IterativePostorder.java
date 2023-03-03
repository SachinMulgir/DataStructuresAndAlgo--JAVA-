import java.util.*;
public class Q_IterativePostorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        BinaryTree bt = new BinaryTree();
        Node root = bt.createTree(arr);

        //Solution:
        List<Integer> ans = iterativePostorder(root);
        System.out.println(ans);
    }
    public static List<Integer> iterativePostorder(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();

        Node node = root;

        while( node != null || st.size() > 0 ){
            if( node != null ){
                st.push(node);
                node = node.left;
            }
            else{
                Node temp = st.peek().right;
                if( temp == null ){
                    temp = st.pop();
                    ans.add(temp.data);
                    while( st.size() > 0 && temp == st.peek().right){
                        temp = st.pop();
                        ans.add(temp.data);
                    }
                }
                else{
                    node = temp;
                }
            }
        }
        return ans;
    }
}
/*
15
1 2 3 -1 -1 4 5 -1 -1 6 -1 -1 7 -1 -1
 */