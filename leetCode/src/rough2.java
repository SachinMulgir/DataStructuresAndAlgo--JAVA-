import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class rough2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        l1.next = l2;
        ListNode l3 = new ListNode(1);
        l2.next = l3;

        System.out.println(getDecimalValue(l1));
    }
public static int getDecimalValue(ListNode head) {
    if( head == null ){
        return head.val;
    }if( head.next == null ){
        return head.val;
    }

    ListNode curr = head;

    //length
    int length = 0;
    while( curr != head ){
        curr = curr.next;
        length++;
    }
    System.out.println("length :"+length);
    //binary to decimal
    curr = head;
    int sum = 0;
    while ( curr != null ){

        if(curr.val == 1){
            sum = sum + power(length - 1);

        }
        curr = curr.next;
        length -- ;
    }
    return sum;
}
    public static int power(int pow){
        int num = 2;
        int ans = 1;
        for( int i=0 ; i<pow ; i++){
            ans = ans*2;
        }
        System.out.println(ans);
        return ans;
    }
}
