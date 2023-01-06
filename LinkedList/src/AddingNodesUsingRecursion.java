import java.util.*;
public class AddingNodesUsingRecursion {
    public static void main(String[] args) {
        LinkedList2 ll = new LinkedList2();

    }
    public static Node insertRecursion( int index, int val, Node node){
        if( index == 0 ){
            Node temp = new Node(val);
            return temp;
        }
        node.next = insertRecursion(index--, val, node.next);
        return node;
    }
}
