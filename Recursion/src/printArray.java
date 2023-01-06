public class printArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int idx=0;
        print(idx,arr);
    }
    public static void print(int idx, int[] arr){
        if(idx==0)return;
        System.out.print(arr[idx]+" ");
        print(idx+1,arr);
    }
}
