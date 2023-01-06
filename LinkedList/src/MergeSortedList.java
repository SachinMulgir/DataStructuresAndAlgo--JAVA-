import java.util.*;
public class MergeSortedList {
    public static void main(String[] args) {
        //list 1: 1=>2=>4
        //list 2: 1=>3=>4
        Scanner sc = new Scanner(System.in);
        System.out.println("enter length of 2 lists :");
        int n = sc.nextInt();
        int m = sc.nextInt();
        LinkedList2 ll1 = new LinkedList2();
        LinkedList2 ll2 = new LinkedList2();
        for( int i = 0; i< n ;i++){
            int a = sc.nextInt();
            ll1.addLast(a);
        }
        for(int i = 0; i<m ;i++){
            int a = sc.nextInt();
            ll2.addLast(a);
        }
        System.out.println("both lists: ");
        ll1.displayList();
        System.out.println();
        ll2.displayList();
    }
}
