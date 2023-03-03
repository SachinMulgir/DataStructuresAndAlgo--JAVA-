import java.util.Scanner;

public class Q_MaxPathSum {
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
        int ans = maxPathSum(root);
        System.out.println(ans);
    }

    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(Node root){
        maxPath(root);
        return max;
    }
    public static int maxPath(Node root){
        if( root == null ){
            return 0;
        }

        int left = maxPath(root.left);
        int right = maxPath(root.right);

        left = Math.max(0, left);                   // we don't take negative values from subtree
        right = Math.max(0, right);                 // since they'll reduce the max sum.[so instead we take 0];

        int currSum = left + right + root.data;
        max = Math.max(max, currSum);

        return (Math.max(left, right) + root.data);
    }
}
/*
11
-10 9 -1 -1 20 15 -1 -1 7 -1 -1

                     -10
                 9          20
                         15      7
 */