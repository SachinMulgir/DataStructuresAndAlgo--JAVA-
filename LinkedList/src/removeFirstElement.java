import java.util.*;
// class Node{              //already created earlier in Introduction file. Global class.
//    int data;             //can be accessed inside the package anywhere
//    Node next;
//
//    public Node(int d){
//    this.data=d;
//    }
// }

public class removeFirstElement {
    static Node Head;
    static Node Tail;

//    public static void removeFirstNode() {
//        if (Head != null) {
//            Node curr = Head;             //optional
//            Head = Head.next;
//            curr.next = null;               //optional
//        }
//    }


    public static void main(String[] args) {
        LinkedList2 ll= new LinkedList2();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            ll.addLast(a);
        }
        System.out.println("before removing first element:");
        ll.displayList();

        //removing 1st node:
        ll.removeFirst();         //function is defined in linked-list function class.

        System.out.println("\nAfter removing 1st node:");
        ll.displayList();

    }
}
