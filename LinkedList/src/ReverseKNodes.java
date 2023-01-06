import java.util.Scanner;

public class ReverseKNodes {
    public static void main(String[] args) {
        LinkedList2 ll = new LinkedList2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for( int i = 0 ; i < n ; i++){
            int a = sc.nextInt();
            ll.addLast(a);
        }
        System.out.print("no of nodes to reverse: ");
        int k = sc.nextInt();
        ll.displayList();
        ll.Head = reverseKGroup(ll.Head , k);
        ll.displayList();
    }
    public static Node reverseKGroup(Node head, int k) {
        if( head == null || head.next == null || k < 2 ){
            return head;
        }
        Node prev = null;
        Node curr = head;
        while( curr != null && curr.next != null ){
            Node last = prev;
            Node newEnd = curr;
            if( length(curr) < k ){
                return head;
            }
            for( int i = 0 ; curr.next != null && i < k ; i++){

                Node nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            if( last == null  ){
                head = prev;
            }else{
                last.next = prev;
            }
            newEnd.next = curr;
            prev = newEnd;
        }
        return head;
    }
    public static int length( Node head){
        int len = 0;
        Node curr = head;
        while( curr != null ){
            len++;
            curr = curr.next;
        }
        return len;
    }
//    public static Node swapKnodes(Node head, int k){
//        Node prev = null;
//        Node curr = head;
//        while( curr != null && curr.next != null ){
//            Node newEnd = curr;
//            Node last = prev;
//            for( int i = 0 ; i < k ; i++ ){
//                Node nextNode = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = nextNode;
//            }
//            if( last == null ){
//                head = prev;
//            }else{
//                last.next = prev;
//            }
//            newEnd.next = curr;
//            prev = newEnd;
//        }
//        return head;
//    }
}
