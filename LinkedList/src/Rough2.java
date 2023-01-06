import java.util.Scanner;

public class Rough2 {
    public static void main(String[] args) {
        LinkedList2 ll = new LinkedList2();
        LinkedList2 ll2 = new LinkedList2();
        Scanner sc = new Scanner(System.in);
        System.out.println("size of 1st list:");
        int n = sc.nextInt();
        System.out.println("elements of 1st list:");
        for( int i = 0 ; i < n ; i++){
            int a = sc.nextInt();
            ll.addLast(a);
        }
        System.out.println("size of 2nd list:");
        int m = sc.nextInt();
        System.out.println("element of 2nd list:");
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            ll2.addLast(a);
        }
        ll.displayList();
        ll2.displayList();

        Node head = addTwoLinkedLists(ll.Head, ll2.Head);
        while( head != null ){
            System.out.println(head.data);
            head = head.next;
        }

    }
    public static Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        while( curr != null ){
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public static Node addTwoLinkedLists(Node head1, Node head2)
    {
        if( head1 == null ) return head2;
        if( head2 == null ) return head1;

        Node p1 = reverse(head1);
        Node p2 = reverse(head2);
        Node ans = null;
        int carry = 0;
        while( p1 != null && p2 != null ){
            Node np1 = p1.next;
            Node np2 = p2.next;

            int val = p1.data + p2.data + carry;
            Node node = new Node(val % 10);
            node.next = ans;
            ans = node;
            if( val > 9 ){
                carry = 1;
            }else{
                carry = 0;
            }
            p1 = np1;
            p2 = np2;
        }

        return ans;
    }
}
