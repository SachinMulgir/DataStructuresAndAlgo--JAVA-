public class DLL {

    private Node head;
    private Node tail;
    private class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
        }
        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public void insertFirst(int data){
        Node node = new Node(data);
        node.next = head;
        node.prev = null;
        if( head != null ){
            head.prev = node;
        }
        head = node;
    }
    public void insertLast(int data){
        Node node = new Node(data);
        if( head == null ){
            head = node;
        }else{
            Node curr = head;
            while( curr.next != null ){
                curr = curr.next;
            }
            curr.next = node;
            node.prev = curr;
            node.next = null;
        }
    }
    public void display(){
        Node curr = head;
        Node last = null;
        while (curr != null){
            System.out.print(curr.data + " -> ");
            last = curr;
            curr = curr.next;
        }
        System.out.println("END");
        System.out.println("reverse linked list");
        while (last != null){
            System.out.print(last.data + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

}
