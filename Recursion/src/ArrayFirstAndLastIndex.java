public class ArrayFirstAndLastIndex {
    public static void main(String[] args) {
        int[] arr={3,2,1,18,9,2,5};
        int target=2;
        System.out.println("first index:"+firstIndex(arr,target,0));
        System.out.println("last index:"+lastIndex(arr,target,arr.length-1));
    }
    public static int firstIndex(int[] arr,int target, int idx){
        if(idx==arr.length)return -1;
        if(arr[idx]==target)return idx;
        return firstIndex(arr,target,idx+1);
    }
    public static int lastIndex(int[] arr,int target,int idx){
        if(idx==-1)return -1;
        if(arr[idx]==target)return  idx;
        return lastIndex(arr,target,idx-1);
    }
}
