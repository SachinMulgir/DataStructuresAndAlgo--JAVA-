//LeetCode 84: //HARD
import java.util.*;
public class Q_LargestHistogramArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("\n\nLargest Area: " + largestArea(arr));
    }
    public static int largestArea(int[] arr){

        // WE'LL CHECK FOR THE NEXT SMALLER ELEMENT ON BOTH THE SIDES:

        // 1. NEXT SMALLER ELEMENT ON LEFT:

        int[] NSEleft = new int[arr.length];
        Stack<Integer> st1 = new Stack<>();
        for( int i = arr.length-1 ; i >= 0 ;i--){
            int element = arr[i];
            if( st1.size() == 0 ){
                st1.push(i);
            }else{
                while( st1.size() > 0 && arr[ st1.peek() ] > element ){
                    int index = st1.peek();
                    NSEleft[index] = i;
                    st1.pop();
                }
                st1.push(i);
            }
        }
        while( st1.size() > 0 ){
            int index = st1.peek();
            NSEleft[index] = -1;
            st1.pop();
        }

        // 2. NEXT SMALLER ELEMENT ON RIGHT:

        int[] NSEright = new int[arr.length];
        Stack<Integer> st2 = new Stack<>();
        for( int i = 0 ; i < arr.length ;i++){
            int element = arr[i];
            if( st2.size() == 0 ){
                st2.push(i);
            }else{
                while( st2.size() > 0 && arr[ st2.peek() ] > element ){
                    int index = st2.peek();
                    NSEright[index] = i;
                    st2.pop();
                }
                st2.push(i);
            }
        }
        while( st2.size() > 0 ){
            int index = st2.peek();
            NSEright[index] = NSEright.length;
            st2.pop();
        }

        // Printing both the lists: NSEleft and NSEright:

        System.out.println("NextSmallerElement on left : " + Arrays.toString(NSEleft));
        System.out.println("NextSmallerElement on right : " + Arrays.toString(NSEright));

        // RUN A LOOP TO RUN THROUGH EACH ELEMENT:
        // for arr[i] :
        //             * NSEleft[i] : will represent the left end of the rectangle.
        //             * NSEright[i] : will represent the right end of the rectangle.

        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = NSEright[i] - NSEleft[i] - 1;
            int area = width * arr[i];
            if( area > maxArea ){
                maxArea = area;
            }
        }
        return maxArea;
    }
}
