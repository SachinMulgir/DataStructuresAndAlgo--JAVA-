import java.util.*;
public class Q_IterativeInorder {
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
        List<Integer> ans = iterativeInorder(root);
        System.out.println(ans);
    }
    public static List<Integer> iterativeInorder(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();

        if( root == null )return ans;
        Node node = root;

        while( node != null || st.size() > 0 ){
            while( node != null ){
                st.push(node);
                node = node.left;
            }

            node = st.pop();
            ans.add(node.data);
            node = node.right;

        }
        return ans;
    }
}
/*
15
1 2 3 -1 -1 4 5 -1 -1 6 -1 -1 7 -1 -1
 */