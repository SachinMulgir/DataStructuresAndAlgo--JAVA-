import java.util.*;
public class Q_IterativePreorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //creating tree:
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        BinaryTree bt = new BinaryTree();
        Node root = bt.createTree(arr);

        //Solution:
        List<Integer> ans = iterativePreorder(root);
        System.out.println(ans);
    }

    public static List<Integer> iterativePreorder(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();

        if( root == null )return ans;
        st.push(root);

        while( st.size() > 0 ){
            //remove:
            Node temp = st.pop();

            //process:
            ans.add(temp.data);

            //add:(first right and then left)
            if( temp.right != null ){
                st.push(temp.right);
            }
            if( temp.left != null ){
                st.push(temp.left);
            }
        }
        return ans;
    }
}
/*
15
1 2 3 -1 -1 4 5 -1 -1 6 -1 -1 7 -1 -1  (preorder input)
 */