import java.util.*;
public class Rough {
    class Pair {
        Node node;
        int scale;

        Pair(Node node, int scale) {
            this.node = node;
            this.scale = scale;
        }
    }
        public ArrayList<Integer> topView(Node root){
            ArrayList<Integer> ans = new ArrayList<>();
            if( root == null ){
                return ans;
            }
            Map<Integer, Integer> hm = new HashMap<>();
            Queue<Pair> q = new LinkedList<>();

            int maxScale = Integer.MIN_VALUE;
            int minScale = Integer.MIN_VALUE;

            q.add(new Pair(root,0));
            while( q.size() > 0 ){
                int size = q.size();
                for( int i  = 0 ; i < size ;i++){
                    Pair info = q.remove();
                    Node temp = info.node;
                    int currScale = info.scale;

                    maxScale = Math.max(maxScale,currScale);
                    minScale = Math.min(minScale, currScale);

                    if( !hm.containsKey(currScale) ){
                        hm.put(currScale, temp.data);
                    }
                    if( temp.left != null ){
                        q.add(new Pair(temp.left, currScale-1));
                    }
                    if( temp.right != null ){
                        q.add( new Pair(temp.right, currScale+1));
                    }
                }
            }
            for( int i = minScale; i <= maxScale ; i++){
                ans.add( hm.get(i) );
            }
            return ans;
        }

    public boolean isCousins( Node root, int x,int y){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 0, lx = 0 , ly = 0;
        boolean flag = false;
        Node xp = root, yp = root;

        while( queue.size() > 0 ) {
            Queue<Node> parent = queue;
            queue = new LinkedList<>();

            for( Node node : parent ){
                if( node.left != null ){
                    queue.add(node.left);
                    if(  node.left.data == x ){
                        lx = level + 1;
                        xp = node;
                        flag = true;
                    }
                    else if( node.left.data == y ){
                        ly = level + 1;
                        yp = node;
                        flag = true;
                    }
                }
                if( node.right != null ){
                    queue.add(node.right);
                    if(  node.right.data == x ){
                        lx = level + 1;
                        xp = node;
                        flag = true;
                    }
                    else if( node.left.data == y ){
                        ly = level + 1;
                        yp = node;
                        flag = true;
                    }
                }
            }
            if(flag){
                break;
            }
            level++;
        }
        return ( lx == ly ) && ( xp != yp ) ? true:false;
    }
            public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        //
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for( int i = 0 ; i < n ; i++){
            ArrayList<Integer> inner  = new ArrayList<>();
            inner.add(arr[i]);
            inner.add(i);
            list.add(inner);
        }
        System.out.println(list);
        //
        Collections.sort(list, (x,y) -> (x.get(0) > y.get(0) ? 1 : -1));
        System.out.println(list);
        //
        for (int i = 0; i < n; i++) {
            if( arr[i] == list.get(i).get(0) ){
                System.out.println(arr[i]);
                return;
            }
        }

    }
}
