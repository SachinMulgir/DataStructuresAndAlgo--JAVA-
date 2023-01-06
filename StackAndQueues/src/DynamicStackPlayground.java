public class DynamicStackPlayground {
    public static void main(String[] args) {
        CustomStack cs = new CustomStack(5);     // static stack of size 5;
        CustomStack cs2 = new CustomStack();         // static stack of default size (i.e 10)

        DynamicStack ds = new DynamicStack(5);   // dynamic stack of size 5;
        DynamicStack ds2 = new DynamicStack();       // dynamic stack of variable size ( no limit )

        for( int i = 0 ; i < 10 ; i++){
            cs2.push(i);
            ds2.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(cs2.pop() + " ");
            System.out.println(ds2.pop());
        }

        //here cs2 cannot go beyond 10 size because it has size limitations
        System.out.println("cs2 size limitation");
        for (int i = 0; i < 15; i++) {
            cs2.push(i);
            ds2.push(i);
        }
        for (int i = 0; i < 15; i++) {
            System.out.print(cs2.pop() + " ");
            System.out.println(ds2.pop());
        }
    }
}
