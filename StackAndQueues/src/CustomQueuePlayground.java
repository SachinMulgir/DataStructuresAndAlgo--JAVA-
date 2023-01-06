public class CustomQueuePlayground {
    public static void main(String[] args) throws Exception {
        CustomQueue q = new CustomQueue();
        for (int i = 0; i < 5; i++) {
            q.insert(i);
        }
        q.display();
        System.out.println("removed: " + q.remove());
        System.out.println("removed: " + q.remove());
        q.display();
    }
}
