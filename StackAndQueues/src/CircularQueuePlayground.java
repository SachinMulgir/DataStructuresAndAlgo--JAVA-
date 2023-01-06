public class CircularQueuePlayground {
    public static void main(String[] args) throws Exception {
        CircularQueue cq = new CircularQueue();
        for( int i = 1 ; i <= 5 ; i++ ){
            cq.insert(i);
        }
        cq.remove();
        cq.remove();
        cq.insert(6);
        cq.insert(8);
        cq.display();
        cq.remove();
        cq.insert(98);
        cq.display();

        DynamicCircularQueue dcq = new DynamicCircularQueue();
        for( int i = 0 ; i < 20 ; i++){
            dcq.insert(i);
        }
        dcq.display();
    }
}
