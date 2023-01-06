import java.util.*;
public class SortLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList2 list = new LinkedList2();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            list.addLast(a);
        }
        list.displayList();
        //sort the list
        list.Head = sortList(list.Head);
        list.displayList();
    }
    public static Node sortList(Node head){
        if( head == null || head.next == null ){
            return head;
        }
        int length = length(head);
        return bubbleSort(head,length-1,0);
    }
    public static Node bubbleSort(Node head, int row, int col){
        if (row == 0) {
            return head;
        }
        if( col < row ){
            Node first = getAt(head,col);
            Node second = getAt(head,col + 1);
            if( first.data > second.data ){
                //if first is head
                if( first == head ){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }else{
                    Node prev = getAt( head,col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            head = bubbleSort(head, row, col + 1);
        }else{
            head = bubbleSort(head, row - 1, 0);
        }
        return head;
    }
    public static Node getAt(Node head , int idx){
        Node curr = head;
        for( int i = 0; i < idx ; i++){
            curr = curr.next;
        }
        return curr;
    }
    public static int length(Node head){
        int length = 0;
        Node curr = head;
        while( curr != null ){
            curr = curr.next;
            length++;
        }
        return length;
    }

}
