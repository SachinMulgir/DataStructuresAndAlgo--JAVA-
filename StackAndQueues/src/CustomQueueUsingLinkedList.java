import java.sql.SQLOutput;
import java.util.LinkedList;
class Node{
    int data;
    Node next;

    public Node(int val){
        this.data = val;
    }
}
class Queue{
    Node front;
    Node back;
    int size = 0;

    public void add(int val){
        Node temp = new Node(val);
        if( front == null && back == null ){
            front = temp;
            back = temp;
        }
        else{
            back.next = temp;
            back = temp;
        }
        size++;
    }

    public int remove(){
        if( front == null ){
            back = null;
            return -1;
        }
        int ans = front.data;
        front = front.next;
        size--;
        return ans;
    }

    public int front(){
        if( front == null ){
            back = null;
            return -1;
        }
        return front.data;
    }

    public int getSize(){
        return size;
    }

    public void display(){
        if( front == null ){
            System.out.print("empty queue");
        }
        else{
            Node curr = front;
            System.out.print("[ ");
            while( curr != null ){
                System.out.print(curr.data + ", ");
                curr = curr.next;
            }
            System.out.println("]");
        }
    }
}

public class CustomQueueUsingLinkedList {

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.display();
        q.add(4);
        q.add(5);
        q.display();
        System.out.println(q.remove());

        System.out.println(q.remove());

        System.out.println(q.remove());
    }

}
