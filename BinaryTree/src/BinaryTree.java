import java.util.*;
class Node extends BinaryTree{
    int  data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }


}
public class BinaryTree{

    // FUNCTION TO CREATE NEW BINARY TREE FROM ARRAY:

    int idx = -1;                             //INDEX TO KEEP THE CHECK;
    public Node createTree( int[] nodes ){
        idx ++;                               // increment idx to get next element:nodes[idx] each time
        if( nodes[idx] == -1 ){
            return null;
        }
        Node newNode = new Node( nodes[idx] );
        newNode.left = createTree(nodes);         // recursion call for left child of nodes.
        newNode.right = createTree(nodes);        // recursion call for right child of nodes.

        return newNode;                           // returns the root of the BinaryTree.
    }

    // TYPES OF TRAVERSALS:
    // 1. PRE-ORDER TRAVERSAL:
    ArrayList<Integer> preOrderList = new ArrayList<>();
    public ArrayList<Integer> preOrderTraversal( Node root ){
        if( root == null ){
            return preOrderList;
        }
        preOrderList.add(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

        return preOrderList;
    }

    // 2. IN-ORDER TRAVERSAL:
    ArrayList<Integer> inOrderList = new ArrayList<>();
    public ArrayList<Integer> inOrderTraversal( Node root ){
        if( root == null ){
            return inOrderList;
        }
        inOrderTraversal(root.left);
        inOrderList.add(root.data);
        inOrderTraversal(root.right);

        return inOrderList;
    }

    // 3. POST-ORDER TRAVERSAL:
    ArrayList<Integer> postOrderList = new ArrayList<>();
    public ArrayList<Integer> postOrderTraversal( Node root ){
        if( root == null ){
            return postOrderList;
        }

        postOrderTraversal( root.left );
        postOrderTraversal( root.right );
        postOrderList.add(root.data);

        return postOrderList;
    }
}