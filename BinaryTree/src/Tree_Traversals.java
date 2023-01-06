public class Tree_Traversals {
    public static void main(String[] args) {
        int[] nodes = { 10, 7, 6, 1, -1, -1, -1, 8, -1, 9, -1, -1, 11, -1, 20, 14, -1, -1, 22, -1, -1 };
        BinaryTree bt = new BinaryTree();
        Node root = bt.createTree(nodes);

        // TRAVERSING THROUGH THE TREE:
        // 1. pre-order:
        System.out.println( bt.preOrderTraversal(root) );

        // 2. IN-order:
        System.out.println( bt.inOrderTraversal(root) );

        // 3. Post-order:
        System.out.println( bt.postOrderTraversal(root) );

    }
}
