import java.util.*;
// class Node{              //already created earlier in Introduction file. Global class.
//    int data;             //can be accessed inside the package anywhere
//    Node next;
//
//    public Node(int d){
//    this.data=d;
//    }
// }

public class PrintLinkedList {
    static Node Head;
    static Node Tail;
    public static void addLast(int data){
        Node nn = new Node(data);
        if(Head == null){
            Head = nn;
            Tail = nn;
        }else{
            Tail.next = nn;
            Tail = nn;
        }
    }

    //Function to print linked-list using recursion.
    public static void displayList(Node n, Node end){
        if(n==end)return;
        System.out.print(n.data+" ");
        displayList(n.next,end);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //taking input of the linked-list
        int n = sc.nextInt();
        Node n1 = new Node(0);
        Head = n1;
        Tail = n1;
        for(int i=1 ; i<=n ; i++){
            int a=sc.nextInt();
            addLast(a);
        }

        //printing linked-list using conditionals
        System.out.println("Printing using while loop:");

        Node curr = Head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();

        //printing the linked-List using Recursion
        System.out.println("Printing using Recursion:");
        displayList(Head, Tail.next);
    }

}
