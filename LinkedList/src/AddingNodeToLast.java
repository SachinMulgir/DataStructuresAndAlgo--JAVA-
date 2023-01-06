import java.util.*;
// class Node{              //already created earlier in Introduction file. Global class.
//    int data;             //can be accessed inside the package anywhere
//    Node next;
//
//    public Node(int d){
//    this.data=d;
//    }
// }


public class AddingNodeToLast {
    static Node Head;                //Global variables that'll point to head and tail.
    static Node Tail;

    public static void addLast(int data){
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
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        // n1->n2->n3

        Head = n1;
        Tail = n2;
        //n1(head) -> n2 -> n3(tail)

        //ADDING ELEMENTS ONE BY ONE:
        addLast(4);    //n1(head) -> n2 -> n3 -> n4(tail)
        addLast(5);    //n1(head) -> n2 -> n3 -> n4 -> n5(tail)

        //ADDING ELEMENTS USING LOOPS
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();             //input of linked-list size
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            addLast(a);
        }
        for(int i=0;i<n;i++){
            System.out.println(Head.next.data);
        }

    }
}
