import java.util.*;
public class Q_BoundaryTraversal {
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
        boundaryTraversal(root);
    }
    public static void boundaryTraversal(Node root){
        if( root == null )return;
        System.out.print(root.data + " ");
        //left boundary:
        leftBoundary(root.left);

        //leaf nodes:
        leafNode(root);

        //right boundary:
        List<Integer> rightBoundary = new ArrayList<>();
        rightBoundary(root.right, rightBoundary);
        for (int i = 0; i < rightBoundary.size(); i++) {
            System.out.print(rightBoundary.get(i) + " ");
        }
    }
    public static void leftBoundary(Node root){
        if( root == null ){
            return;
        }
        if( root.left != null ){
            System.out.print(root.data + " ");
            leftBoundary(root.left);
        }
        else if( root.right != null ){
            System.out.print(root.data + " ");
            leftBoundary(root.right);
        }
    }
    public static void leafNode(Node root){
        if( root == null )return;

        leafNode(root.left);
        if( root.left == null && root.right == null ){
            System.out.print(root.data + " ");
        }
        leafNode(root.right);
    }

    public static void rightBoundary(Node root, List<Integer> list){
        if( root == null )return;

        if( root.right != null ){
            list.add(0, root.data);
            rightBoundary(root.right, list);
        }
        else if( root.left != null ){
            list.add(0, root.data);
            rightBoundary(root.left,list);
        }

    }
}
/*

23
1 2 3 -1 4 5 -1 -1 6 -1 -1 -1 7 -1 8 9 10 -1 -1 11 -1 -1 -1

19
1 2 3 4 5 6 7 8 9 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
 */