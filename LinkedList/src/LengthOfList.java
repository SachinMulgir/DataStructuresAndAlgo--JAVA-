import java.util.*;
public class LengthOfList {
//    public static int length(){
//        Node curr = Head;
//        int count = 0;
//        while( curr != null ){
//            curr = curr.next;
//            count++;
//        }
//        return count;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList2 ll = new LinkedList2();
        LinkedList<Integer> list = new LinkedList<>();

        int n = sc.nextInt();
        for( int i=0 ; i<n ; i++){
            int a = sc.nextInt();
            ll.addLast(a);
        }
        //calling the length function from linked list class
        int length = ll.length();
        System.out.println(length);
    }
}
