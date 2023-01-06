public class DynamicStack {
    protected int[] data;
    private static final int DefaultSize = 10;

    int ptr = -1;

    public DynamicStack(){
        this(DefaultSize);
    }
    public DynamicStack(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return  ptr == data.length-1;
    }
    public boolean isEmpty(){
        return ptr == -1;
    }

    public boolean push(int item){
        if( isFull() ){
            //create new array of 2*size
            int[] temp = new int[data.length*2];
            //copy all the items into new array
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            //make new array as the main stack array
            data = temp;
        }
        //if not full:
        ptr++;
        data[ptr] = item;
        return true;
    }
    public int pop(){
        return data[ptr--];
    }
    public int peek(){
        return data[ptr];
    }
}
