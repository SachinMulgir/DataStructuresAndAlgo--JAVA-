import java.util.*;
public class Q_LevelOrderTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        BinaryTree bt = new BinaryTree();
        Node root = bt.createTree(arr);
        //
        ArrayList<ArrayList<Integer>> ans = levelOrderTraversal(root);
        System.out.println(ans);
    }
    public static ArrayList<ArrayList<Integer>> levelOrderTraversal(Node root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if( root == null ){
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while( q.size() > 0 ){
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node temp = q.remove();
                level.add( temp.data );
                if( temp.left != null ){
                    q.add( temp.left );
                }
                if( temp.right != null ) {
                    q.add(temp.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
