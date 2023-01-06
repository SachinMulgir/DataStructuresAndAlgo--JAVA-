import java.util.*;
public class RotateList {
    public static void main(String[] args) {
        LinkedList2 ll = new LinkedList2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for( int i = 0 ; i < n ; i++){
            int a = sc.nextInt();
            ll.addLast(a);
        }
        System.out.print("no of rotations : ");
        int k = sc.nextInt();
        ll.displayList();
        ll.Head = rotateList(ll.Head, k);
        ll.displayList();
    }
    public static Node rotateList(Node head, int k) {
        int length = length(head);
        System.out.println("length: " + length);
        int skip = length - k - 1;
        System.out.println("skip: " + skip);
        Node curr = head;
        Node newLast = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        System.out.println("curr val: " + curr.data);
        for (int i = 0; i < skip; i++) {
            newLast = newLast.next;
        }
        System.out.println("newLast: " + newLast.data);
        curr.next = head;
        head = newLast.next;
        newLast.next = null;
        return head;
    }
    public static int length(Node head){
        int len = 0;
        Node curr = head;
        while( curr != null ){
            curr = curr.next;
            len++;
        }
        return len;
    }

}
