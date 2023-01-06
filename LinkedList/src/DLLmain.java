public class DLLmain {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);
        list.display();
        System.out.println();
        System.out.println("ANOTHER DOUBLY LINKEDLIST");
        DLL list2 = new DLL();
        list2.insertLast(11);
        list2.insertLast(12);
        list2.insertLast(13);
        list2.insertLast(14);
        list2.insertLast(15);
        list2.display();

    }
}
