import java.util.*;

public class RemoveAtParticularIndex {
//    public static void removeAt(int n){
//        if( Head == null){
//            System.out.println("Empty list");
//        }else if( Head == Tail ){
//            if( n == 0 ){
//                Head = Head.next;
//            }else{
//                System.out.println("Invalid index");
//            }
//        }else{
//            Node curr = Head;
//            for( int i =0 ; i < n-1  ; i++){
//                curr = curr.next;
//            }
//            if( curr.next.next == null){
//                curr.next = null;
//                Tail = curr;
//            }else{
//                curr.next = curr.next.next;
//                curr.next.next=null;
//            }
//
//        }
//    }
    public static void main(String[] args) {
        LinkedList2 ll= new LinkedList2();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0 ; i<n ;i++){
            int a = sc.nextInt();
            ll.addLast(a);
        }
        //remove at index:
        System.out.println("remove at index:");
        int x = sc.nextInt();
        System.out.println("tail.data="+ll.Tail.data);
        ll.removeAt(x);
        ll.displayList();
        System.out.println("Tail");
        System.out.println(ll.Tail.data);

    }
}
