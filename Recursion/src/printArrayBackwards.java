public class printArrayBackwards {
    public static void main(String[] args) {
        int[] arr={6,5,4,1,2,5,74};
        pArrBackward(0,arr);
    }
    public static void pArrBackward(int idx,int[] arr){
        if(idx==arr.length)return;
        pArrBackward(idx+1,arr);
        System.out.print(arr[idx]+" ");
    }
}
