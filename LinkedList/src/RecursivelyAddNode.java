public class RecursivelyAddNode {
    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(5);
        list.addLast(6);
        list.displayList();


        list.Head = addAtRecursively(3,4 , list.Head);
        list.displayList();
    }
    public static Node addAtRecursively( int index, int value, Node node){
        if( index == 0 ){
            Node newNode = new Node(value);
            newNode.next = node;
            return newNode;
        }
        node.next = addAtRecursively(index-1 , value, node.next);
        return node;
    }
}
