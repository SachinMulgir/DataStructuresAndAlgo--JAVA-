import java.util.*;
public class Q_LeftView {
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
        List<Integer> ans = leftView(root);
        System.out.println(ans);
    }

    public static List<Integer> leftView(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        List<Integer> ans = new ArrayList<>();

        while( q.size() > 0 ){
            int size = q.size();
            for (int i = 0; i < size; i++) {

                //Remove:
                Node temp = q.remove();

                //Process:
                if( i == 0 )ans.add(temp.data);

                //Add:
                if( temp.left != null )q.add(temp.left);
                if( temp.right != null )q.add(temp.right);
            }
        }
        return ans;
    }
}
/*
29
7 3 1 0 -1 -1 2 -1 -1 6 4 -1 5 -1 -1 -1 12 9 -1 11 10 -1 15 -1 -1 -1 13 -1 -1



                                       -7-
                           -3-                    -12-
                     -1-         -6          9-          13
                  0      2     4-               -11
                                   5           10-
                                                  12
 */