import java.util.*;
public class PlayingGameFinalModuleExam {
    static Node Head;
    static Node Tail;
    public static void addNode(int data){
        Node nn = new Node(data);
        if(Head == null){                     //condition for 0-sized linked list(i.e head=tail=null);
            Head = nn;                        //1st element added and head=> nn(1st element only);
            Tail = nn;                        //1st element added and tail=> nn(1st element only);
        }else{          //condition for 1 or large size list
            Tail.next = nn;                  //existing TAIL will point to new address instead of NULL.
            Tail = nn;                       //since new element is added at end. new element at last=>TAIL
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            addNode(data);
        }
        Node head = correctOrder(Head);
        display(head);
    }
    public static Node correctOrder(Node head){
        Node mid = findMid(head);
        Node curr = head;
        while( curr.next != mid ){
            curr = curr.next;
        }
        curr.next = null;
        Node head2 = reverse(mid);
        head = merge(head, head2);
        return head;
    }
    public static Node merge(Node list1, Node list2){
        Node p1 = list1;
        Node p2 = list2;
        while( p2 != null ){
            Node np1 = p1.next;
            Node np2 = p2.next;

            p1.next = p2;
            p2.next = np1;

            p1 = np1;
            p2 = np2;
        }
        return list1;
    }
    public static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        while( curr != null ){
            Node nextNode = curr.next;

            curr.next = prev;

            prev = curr;
            curr = nextNode;
        }
        head = prev;
        return head;
    }
    public static Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while( fast != null  && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void display(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print( curr.data + " ");
            curr = curr.next;
        }
    }
}
