import java.util.*;
public class CompareLinkedList {
    static class  Node{
        static int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    static class LinkedList3{
        static Node head;
        static void add(int data ){
            Node new_node = new Node(data);
            if(head == null){
                head = new_node;
                return;
            }
            Node current = head;
            while(current.next !=null){
                current = current.next;
            }
            current.next = new_node;
        }
        public static void printList(){
            Node curr = head;
            while( curr != null ){
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        LinkedList3 ll1 = new LinkedList3();
        LinkedList3 ll2 = new LinkedList3();
        //1st list
        System.out.println("first list:");
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            ll1.add(a);
        }
        //second list
        System.out.println("second list:");
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            ll2.add(a);
        }
        ll1.printList();
        System.out.println();
        ll2.printList();

    }

}
