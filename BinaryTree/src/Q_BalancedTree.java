import java.util.*;
public class Q_BalancedTree {
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
        boolean ans = isBalanced(root);
        System.out.println(ans);
    }
    public static boolean isBalanced(Node root){
        if( root == null )return true;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        int diff = Math.abs(lh - rh);
        if( diff > 1 )return false;

        return ( isBalanced(root.left) && isBalanced(root.right) );
    }

    public static int maxDepth(Node root){
        if( root == null )return 0;

        return 1 + Math.max(maxDepth(root.left) , maxDepth(root.right));
    }
}
/*
13
1 2 -1 -1 3 4 5 -1 -1 -1 6 -1 -1
 */