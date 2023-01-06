import java.util.*;
// class Node{              //already created earlier in Introduction file. Global class.
//    int data;             //can be accessed inside the package anywhere
//    Node next;
//
//    public Node(int d){
//    this.data=d;
//    }
// }


public class AddingNodeToStart {
    static Node Head;
    static Node Tail;
    public static void addFirst(int data){
        Node nn = new Node(data);
        if(Head == null){
            Head = nn;
            Tail = nn;
        }else{
            nn.next = Head;
            Head = nn;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node n1 = new Node(1);
        Node n2 = new Node(2);

        Head=n1;
        Tail=n2;

        System.out.println("ADD TO START OF LINKED-LIST");
        System.out.println("Enter no. of elements:");
        int n=sc.nextInt();
        System.out.println("Enter "+n+" elements:");
        for(int i = 0; i < n ; i++ ){
            int a = sc.nextInt();
            addFirst(a);
        }
    }

}
