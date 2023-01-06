public class maxElementInArray {
    public static void main(String[] args) {
        int[] arr={2,6,7,8,9,4,2};
        System.out.println(findMax(0,arr));
    }
    public static int findMax(int idx,int[] arr){
        if(idx==arr.length)return arr[idx-1];
        int sAns=findMax(idx+1,arr);
        int ans=Math.max(sAns,arr[idx]);
        return ans;
    }

}

