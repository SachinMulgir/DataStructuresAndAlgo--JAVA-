//class Node{                     //class is defined for name Node
//    int data;                   //data inside the node
//
//    public Node(){
//    }
//    public Node(int d){
//        this.data=d;
//    }
//    Node next;                  //variable of Node type to store address of Node type object(i.e next node)
//}
public class Introduction {
    public static void main(String[] args) {
        Node first=new Node();     //first= pointer: pointing to a newly created object of Node type;
        first.data=1;              //'.' operator is used to access data of the Node class

        Node second=new Node();    //second=pointer: pointing to a newly created object of Node type;
        second.data=2;             //'.' operator is used to access the variable of Node class
        first.next=second;         //IMPORTANT: first.next stores the address of the next node;
        //since 'second' is the pointer for the next object of node type....therefore we'll store the address
        //value of second that is (second) into first.next;

        System.out.println(first.data);
        System.out.println(second.data);
        System.out.println(second);
        System.out.println(first.next);
        System.out.println(first.next.data);

    }
}
