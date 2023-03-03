import java.util.*;

public class Q_DiameterOfTree {
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
        int ans = diameter(root);
        System.out.println(ans);
    }


    static int max = 0;                            //global variable to store the max
    public static int diameter(Node root){
        if( root == null )return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        max = Math.max(lh+rh , max);             // max of (lh+rh) is the diameter

        diameter(root.left);
        diameter(root.right);

        return max;
    }
    public static int height(Node root){
        if( root == null )return 0;

        return 1 + Math.max(height(root.left), height(root.right));
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