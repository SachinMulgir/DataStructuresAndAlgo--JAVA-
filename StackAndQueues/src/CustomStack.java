// we're creating a class CustomStack which will create a stack of default size = 10. Whenever we will
// try to push() element beyond the 10th element, it'll throw an exception
// ** note: we can set the size of stack according to our need, while declaring a Stack **
// ** note: only by default it'll create an array of size = 10 **


public class CustomStack {
    protected int[] data;
    private static final int DefaultSize = 10;

    int ptr = -1;

    public CustomStack(){
        this(DefaultSize);
    }
    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return ptr == data.length-1;
    }
    public boolean isEmpty(){
        return ptr == -1;
    }

    public boolean push(int item){
        if( isFull() ){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        this.data[ptr] = item;
        return true;
    }
    public int pop(){
        int returned = this.data[ptr];
        ptr--;
        return returned;
    }
    public int peek(){
        return data[ptr];
    }
}
