import java.util.*;
//
//
//
//
public class QuestOfNamiFinalModuleExam {
    static Node Head;
    static Node Tail;

    public static Node getAt(int index){
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

    public static int size(){
        Node curr = Head;
        int size = 0;
        while( curr != null ){
            curr = curr.next;
            size++;
        }
        return size;
    }
    public static void addNode(int data){
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
        Scanner sc = new Scanner(System.in);
        //create linked-list
        int n = sc.nextInt();
        for( int i = 0 ; i < n ; i++ ){
            int a = sc.nextInt();
            addNode(a);
        }
        //fetch length of the list :
        int length = size();
        int i = 0;
        int j = length-1;
        int max = Integer.MIN_VALUE;
        while( i < j ){

            Node nodeAtI = getAt(i);
            Node nodeAtJ = getAt(j);

            int sum = nodeAtJ.data + nodeAtI.data;
            if(sum > max){
                max = sum;
            }
            i++;
            j--;
        }
        System.out.println(max);
    }
}
