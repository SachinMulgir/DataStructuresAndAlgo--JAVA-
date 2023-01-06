import java.util.*;
public class Q_MIN_Stack {
    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(512);
        m.push(-1024);
        m.push(-1024);
        m.push(512);
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
    }
}
class MinStack {
    Stack<Integer> data;
    Stack<Integer> min;

    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        data.push(val);
        if( min.size() == 0 || val <= min.peek() ){
            min.push(val);
        }
    }
    public void pop() {
        int val = data.pop();
        if( val == min.peek() ){
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
