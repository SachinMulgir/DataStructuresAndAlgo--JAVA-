import java.util.*;

import java.util.*;
public class Q_SameTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1st tree:
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 2nd tree:
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        BinaryTree bt = new BinaryTree();
        Node root1 = bt.createTree(arr);
        BinaryTree bt2 = new BinaryTree();
        Node root2 = bt2.createTree(arr2);

        //Solution:
        boolean ans = sameTree(root1, root2);
        System.out.println(ans);
    }
    public static boolean sameTree(Node root1, Node root2){
        if( root1 == null && root2 == null ){
            return true;
        }
        if( root1 == null && root2 != null ){
            return false;
        }
        if( root1 != null && root2 == null ){
            return false;
        }
        if( root1.data != root2.data ){
            return false;
        }
        return sameTree(root1.left, root2.left) && sameTree( root1.right, root2.right);
    }
}
/*
11
-10 9 -1 -1 20 15 -1 -1 7 -1 -1
 */