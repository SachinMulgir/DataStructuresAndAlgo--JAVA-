import java.util.*;
// class Node{              //already created earlier in Introduction file. Global class.
//    int data;             //can be accessed inside the package anywhere
//    Node next;
//
//    public Node(int d){
//    this.data=d;
//    }
// }

public class ElementAtNthIndex {
    static Node Head;
    static Node Tail;
    //------------------------------------------------------------------------------------------------
    // REQUIRED FUNCTION: TO DISPLAY ELEMENT AT PARTICULAR INDEX
    public static Node displayIndex(int index){
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
    //------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0; i<n ; i++ ){
            int a = sc.nextInt();
            addLast(a);
        }
        System.out.print("fetch at index:");
        int i = sc.nextInt();

        //display at index 'i'
        Node ans = displayIndex(i);
        System.out.println(ans.data);
    }
    public static void addLast(int data){
        Node nn = new Node(data);
        if( Head == null) {
            Head = nn;
            Tail = nn;
        }else{
            Tail.next = nn;
            Tail = nn;
        }
    }
}
