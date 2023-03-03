import java.util.*;

public class Q_RightView {
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
        List<Integer> ans = RightView(root);
        System.out.println(ans);
    }

    public static List<Integer> RightView(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        List<Integer> ans = new ArrayList<>();

        while( q.size() > 0 ){
            int size = q.size();
            for (int i = 0; i < size; i++) {

                //Remove:
                Node temp = q.remove();

                //Process:
                if( i == (size - 1 ) )ans.add(temp.data);

                //Add:
                if( temp.left != null )q.add(temp.left);
                if( temp.right != null )q.add(temp.right);
            }
        }
        return ans;
    }
}
/*

 */