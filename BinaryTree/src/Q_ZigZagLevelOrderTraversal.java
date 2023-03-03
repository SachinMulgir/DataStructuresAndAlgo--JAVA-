import java.util.*;
public class Q_ZigZagLevelOrderTraversal {
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
        List<List<Integer>> ans = zigZagLevelOrder(root);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static List<List<Integer>> zigZagLevelOrder(Node root){

        List<List<Integer>> ans = new ArrayList<>();
        if( root == null ){
            return ans;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while( q.size() > 0 ){
            int size = q.size();
            List<Integer> sAns = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                //remove:
                Node curr = q.remove();

                //Process:
                if( level % 2 == 0 ){
                    sAns.add(curr.data);
                }
                else{
                    sAns.add(0, curr.data);
                }

                //Add:
                if( root.left != null ){
                    q.add(root.left);
                }
                if( root.right != null ){
                    q.add(root.right);
                }
            }
            level++;
            ans.add(sAns);
        }
        return ans;
    }
}
