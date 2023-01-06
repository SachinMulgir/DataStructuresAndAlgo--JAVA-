public class ArrayIncreasing {
    public static void main(String[] args) {
        int[] arr={1,2,4,8,9,12};
        System.out.println(arrInc(arr,0));
    }
    public static boolean arrInc(int[] arr,int idx){
        if(idx==arr.length-1)return true;
        return ((arr[idx]<arr[idx+1]) && arrInc(arr,idx+1));
    }
}
