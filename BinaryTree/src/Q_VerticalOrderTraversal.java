import java.util.*;
public class Q_VerticalOrderTraversal {
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
        List<List<Integer>> ans = verticalTraversal(root);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
    static class Pair{
        Node node;
        int vIdx;

        Pair( Node node, int idx){
            this.node = node;
            this.vIdx = idx;
        }
    }

    public static List<List<Integer>> verticalTraversal(Node root) {
        Map<Integer, List<Integer>> hm = new HashMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        int minVidx = 0;
        int maxVidx = 0;

        while( q.size() > 0 ){
            int size = q.size();
            for( int i = 0 ; i < size ; i++){

                //Remove:
                Pair temp = q.remove();

                //Process:
                Node node = temp.node;
                int vIdx = temp.vIdx;
                if( vIdx > maxVidx )maxVidx = vIdx;
                if( vIdx < minVidx )minVidx = vIdx;

                if( hm.containsKey(vIdx) ){
                    List<Integer> list = hm.get(vIdx);
                    list.add(node.data);
                    hm.put(vIdx, list);
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(node.data);
                    hm.put(vIdx, list);
                }

                //Add:
                if( node.left != null ){
                    q.add(new Pair(node.left, vIdx - 1));
                }
                if( node.right != null ){
                    q.add(new Pair(node.right, vIdx + 1));
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for( int i = minVidx ; i <= maxVidx ; i++){
            ans.add(hm.get(i));
        }

        return ans;

    }
}
