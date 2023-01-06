class Node extends LinkedList2 {             //class is defined for name Node
    int data;           //data inside the node
    Node next;         //variable of Node type to store address of Node type object(i.e next node)

    public Node(){      //constructor
    }
    public Node(int d){  //constructor
        this.data=d;
    }
    public Node(int d , Node node){
        this.data = d;
        this.next = node;
    }
}
public class LinkedList2 {
    static Node Head;
    static Node Tail;

    //================================================================================================
    // LENGTH OF THE LINKED-LIST:

    public static int length(){
        Node curr = Head;
        int size = 0;
        while( curr != null ){
            curr = curr.next;
            size++;
        }
        return size;
    }



    //=================================================================================================
    // ADD ELEMENT TO THE START OF THE LIST:

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
    //=================================================================================================
    // ADD ELEMENT TO THE END OF THE LINKED LIST:

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
    //===================================================================================================
    // ADD ELEMENT AT ANY GIVEN INDEX:

    public static void addAt(int idx, int data){
        Node nn = new Node(data);
        if( idx == 0 ){
            nn.next = Head;
            Head = nn;
        }else if (Head == null){
            Head = nn;
            Tail = nn;
        }else{
            Node curr = Head;
            for( int i=0 ; i<=idx ; i++){
                if(i == idx-1){
                    Node nextN= curr.next;
                    curr.next = nn;
                    nn.next = nextN;
                }
                if( curr.next == null ){
                    Tail = curr;
                    break;
                }
                curr = curr.next;
            }
        }
    }

    //==================================================================================================
    // RETURN NODE AT Nth INDEX:

    public static Node displayAt(int index){
        if( index < 0){
            return null;
        }
        Node curr = Head;
        while( index > 0){
            curr = curr.next;
            if(curr == null){
                return null;
            }
            index--;
        }
        return curr;
    }

    //===================================================================================================
    // DISPLAY LINKED LIST: Print the whole linked-list
    public static void displayList(){
        Node curr = Head;
        while(curr != null){
            System.out.print( curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("End");
    }

    //==================================================================================================
    // REMOVE FIRST NODE:Remove 1st node from the list, consider head is given.

    public static void removeFirst(){
        if(Head == null){
            System.out.println("Empty List");
            return;
        }else if( Head == Tail){
            Head = null;
            Tail = null;
        }else{
            Head = Head.next;
        }
    }

    //==================================================================================================
    // REMOVE LAST NODE: Remove the last node and return its value, consider head is given.

    public static Node removeLast(){
       if(Head == null){
           System.out.print("Empty list");
           return null;
       }else if( Head == Tail ) {
           Node toReturn = Tail;
           Head = Head.next;
           return toReturn;
       }else{
           Node curr = Head;
           while( curr.next != Tail){
               curr = curr.next;
           }
           Node toReturn  = Tail;
           curr.next = null;
           Tail = curr;
           return toReturn;
       }
    }

    //================================================================================================
    // REMOVE AT A PARTICULAR INDEX:

    public static void removeAt(int n){
        if( Head == null){
            System.out.println("Empty list");
        }else if( Head == Tail ){
            if( n == 0 ){
                Head = Head.next;
            }else{
                System.out.println("Invalid index");
            }
        }else{
            Node curr = Head;
            for( int i =0 ; i < n-1  ; i++){
                curr = curr.next;
            }
            if( curr.next == Tail){
                curr.next = null;
                Tail = curr;
            }else{
                curr.next = curr.next.next;
            }

        }
    }
    //=============================================================================================

    public static Node oddEven(Node Head){
        if( Head == null || Head.next == null){
            return Head;
        }
        Node odd = Head;
        Node even = Head.next;
        Node evenHead = Head.next;
        while( odd.next != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next.next;

            even.next = even.next.next;
            even = even.next.next;
        }
        odd.next = evenHead;
        return Head;

    }


}
