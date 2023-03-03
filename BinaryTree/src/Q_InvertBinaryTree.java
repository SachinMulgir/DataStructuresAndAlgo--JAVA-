import java.util.*;
public class Q_InvertBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        BinaryTree bt = new BinaryTree();
        Node root = bt.createTree(arr);

        // Solution:
        Node ans = invertTree(root);
        bt.display(ans);
    }
    public static Node invertTree(Node root){
        if( root == null )return null;

        Node left = invertTree(root.left);
        Node right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
/*
13
1 2 -1 -1 3 4 5 -1 -1 -1 6 -1 -1

                 1
        2                3
      n   n          4       6
                   5   n    n  n
 */