import java.util.*;
public class Q_HouseRobberBinaryTree {
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
        int ans = HouseRobber(root);
        System.out.println(ans);
    }
    public static int HouseRobber(Node root){
        int[] ans = robbery(root);
        return Math.max(ans[0], ans[1]);
    }

    public static int[] robbery(Node root){
        if( root == null ){
            return new int[]{0,0};
        }

        int[] left = robbery(root.left);
        int[] right = robbery(root.right);

        int[] ans = new int[2];

        //rob: skip of left + skip of right:
        ans[0] = left[1] + right[1] + root.data;

        //skip: Math.max( left rob, left skip) + Math.max( right rob, right skip)
        ans[1] = Math.max(left[0], left[1]) + Math.max( right[0], right[1]);

        return ans;
    }
}

/*
19
2 7 2 -1 -1 6 5 -1 -1 11 -1 -1 5 -1 8 4 -1 -1 -1

 */