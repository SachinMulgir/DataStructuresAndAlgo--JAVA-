import java.util.*;
public class ReverseLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList2 ll = new LinkedList2();
        int n = sc.nextInt();
        for( int i=0 ; i<n ; i++ ){
            int a = sc.nextInt();
            ll.addLast(a);
        }
        System.out.println("list:");
        ll.displayList();
        System.out.println("\n reverse list: ");
        ll.Head = reverse(ll.Head);
        ll.displayList();

    }
    public static Node reverse(Node head){
        Node dummy = null;
        Node curr = head;
        while( curr != null ){
            Node nextNode = curr.next;

            curr.next = dummy;
            dummy = curr;
            curr = nextNode;
        }
        return dummy;
    }
}
