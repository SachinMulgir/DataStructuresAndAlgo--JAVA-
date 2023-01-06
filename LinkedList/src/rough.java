
import java.util.*;

class Node1 {
    int data;
    Node1 next;
    public Node1(int d){
        this.data = d;
    }
}
public class rough {
    static Node1 head;
    static Node1 tail;
    public static Node1 oddEven(){
        if( head == null || head.next == null){
            return head;
        }
        Node1 odd = head;
        Node1 even = head.next;
        Node1 evenHead = head.next;
        while( even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            addLast(a);
        }
        int toAdd = sc.nextInt();
        addLast(toAdd);
        head = oddEven();
        display(head);
    }





    public static void addLast(int data){
        Node1 nn = new Node1(data);
        if(head == null){
            head = nn;
            tail = nn;
        }else{
            tail.next = nn;
            tail = nn;
        }
    }
    public static void display(Node1 head){
        Node1 curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
