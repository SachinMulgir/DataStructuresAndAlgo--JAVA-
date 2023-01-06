import java.util.*;
public class CreatingBinaryTree {
    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree bt = new BinaryTree();
        Node root = bt.createTree(nodes);
        System.out.println(root.data);

    }
}
