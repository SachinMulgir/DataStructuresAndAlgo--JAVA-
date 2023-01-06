import java.util.*;
public class CustomQueue {
    private int[] data;
    private static final int defaultSize = 10;

    int end = -1;

    public CustomQueue(){
        this(defaultSize);
    }
    public CustomQueue(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return end == data.length-1;
    }
    public boolean isEmpty(){
        return end == -1;
    }

    public boolean insert(int item){
        if( isFull() ){
            System.out.println("StackFull");
        }
        end++;
        data[end] = item;
        return true;
    }
    public int remove() throws Exception{
        if( isEmpty() ){
            throw new Exception("StackEmpty");
        }
        int removed = data[0];
        //shift all element to left
        for (int i = 1; i <= end ; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public int front(){
        return data[0];
    }
    public void display(){
        for (int i = 0; i <= end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("End");
    }
}
