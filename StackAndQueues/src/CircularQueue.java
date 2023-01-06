import java.util.*;
public class CircularQueue {
    protected int[] data;
    protected static final int defaultSize = 10;

    int front = 0;
    int end = 0;
    int size = 0;

    public CircularQueue(){
        this(defaultSize);
    }
    public CircularQueue(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return size == data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public boolean insert(int item) throws Exception{
        if( isFull() ){
            throw new Exception("StackOverflowException");
        }
        data[end] = item;
        end++;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception{
        if( isEmpty() ){
            throw new Exception("EmptyStackException");
        }
        int removed = data[front];
        front++;
        front = front % data.length;
        size--;
        return removed;
    }

    public int front(){
        return data[front];
    }

    public void display(){
        int idx = front;
        for (int i = 0; i < size; i++) {
            System.out.print(data[(idx + i) % data.length] + " <- ");
        }
        System.out.println("End");
    }

}
