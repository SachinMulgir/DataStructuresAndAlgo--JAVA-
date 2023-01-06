import java.util.*;
// class Node{              //already created earlier in Introduction file. Global class.
//    int data;             //can be accessed inside the package anywhere
//    Node next;
//
//    public Node(int d){
//    this.data=d;
//    }
// }

public class AddingNodeToIndex {
    static Node head;
    static Node tail;
    //===================================================================================================
    public static void addAt(int idx, int data){
        Node nn = new Node(data);
        if( idx == 0 ){
            nn.next = head;
            head = nn;
        }else if (head == null){
            head = nn;
            tail = nn;
        }else{
            Node curr = head;
            for( int i=0 ; i<=idx ; i++){
                if(i == idx-1){
                    Node nextN= curr.next;
                    curr.next = nn;
                    nn.next = nextN;
                }
                if( curr.next == null ){
                    tail = curr;
                    break;
                }
                curr = curr.next;
            }
        }
    }
    //===================================================================================================
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0 ; i<n ; i++){
            int a = sc.nextInt();
            addLast(a);
        }
        //now we'll try to add a Node at given index.
        System.out.println("INSERT: \nAt index:");
        int index = sc.nextInt();
        System.out.println("Insert element:");
        int element = sc.nextInt();

        addAt(index,element);

        //display list after adding 15 at index 2:
        displayList(head, tail);
    }
    public static void addLast(int data){
        Node nn = new Node(data);
        if(head == null){
            head = nn;
            tail = nn;
        }else{
            tail.next = nn;
            tail = nn;
        }
    }
    public static void displayList(Node n, Node end){
        System.out.print(n.data+" ");
        if(n==end)return;
        displayList(n.next,end);
    }
}
