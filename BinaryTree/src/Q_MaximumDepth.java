import java.util.*;
public class Q_MaximumDepth {
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
        int ans = maxDepth(root);
        System.out.println(ans);
    }
    public static int maxDepth(Node root){
        if( root == null ){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
/*

13
1 2 -1 -1 3 4 5 -1 -1 -1 6 -1 -1

 */