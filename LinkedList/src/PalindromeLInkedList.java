import java.util.Scanner;
// WE'LL TAKE THE MID OF THE LIST AND WILL REVERSE THE NEXT HALF OF THE LIST
// THEN WE'LL COMPARE THE 1ST HALF WITH THE 2ND HALF
// IF ALL VALUE EQUAL...... ----PALINDROME-----
public class PalindromeLInkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList2 ll = new LinkedList2();
        int n = sc.nextInt();
        for( int i=0 ; i<n ; i++ ){
            int a = sc.nextInt();
            ll.addLast(a);
        }
        //solution
        Solution obj = new Solution();
        System.out.println(obj.isPalindrome(ll.Head));
    }
}
class Solution {
    public boolean isPalindrome(Node head) {
        Node firstHalf = head;
        Node secondHalf = getMid(firstHalf);
        secondHalf = reverse(secondHalf);

        return compare(firstHalf, secondHalf);
    }
    public boolean compare(Node head1, Node head2){
        Node list1 = head1;
        Node list2 = head2;
        while( list1 != null && list2 != null ){
            if( list1.data != list2.data ){
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return true;
    }
    public Node reverse(Node head){
        if( head == null || head.next == null ){
            return head;
        }
        Node prev = null;
        Node curr = head;
        while( curr != null ){
            Node nextNode = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public Node getMid(Node head){
        Node fast = head;
        Node slow = head;
        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
