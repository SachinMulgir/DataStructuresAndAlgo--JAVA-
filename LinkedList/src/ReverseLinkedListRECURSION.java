import java.util.*;
public class ReverseLinkedListRECURSION {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList2 list = new LinkedList2();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            list.addLast(a);
        }
        //finding tail
        Node tail = new Node();
        Node curr = list.Head;
        while( curr.next!= null ){
            curr = curr.next;
        }
        tail = curr;
        list.displayList();
        reverse(list.Head , tail);
        list.displayList();
    }
    public static void reverse(Node head, Node tail){
        if( head == tail ){
            head = tail;
            return;
        }
        reverse(head.next, tail);
        tail.next = head;
        tail = head;
        tail.next = null;
    }
}
