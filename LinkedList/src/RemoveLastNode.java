import java.util.*;
// class Node{              //already created earlier in Introduction file. Global class.
//    int data;             //can be accessed inside the package anywhere
//    Node next;
//
//    public Node(int d){
//    this.data=d;
//    }
// }

public class RemoveLastNode {
    static Node Head;
    static Node Tail;

//    public static Node removeLast(){                   //already described in linked-list class
//        if( Head == null ){
//            System.out.println("Empty list");
//            return null;
//        }else if( Head == Tail ){
//            Node toReturn = Tail;
//            Head = Head.next;
//            return toReturn;
//        }else{
//            Node curr = Head;
//            while( curr.next != Tail ){
//                curr = curr.next;
//            }
//
//            Node toReturn = Tail;
//            curr.next = null;
//            Tail = curr;
//
//            return toReturn;
//        }
//    }
    public static void main(String[] args) {
        LinkedList2 ll= new LinkedList2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for( int i=0 ; i<n ; i++){
            int a = sc.nextInt();
            ll.addLast(a);
        }
        //remove last
        ll.removeLast();
        //print
        ll.displayList();

    }
}
