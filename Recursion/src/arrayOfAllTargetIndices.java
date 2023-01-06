import java.util.Arrays;

public class arrayOfAllTargetIndices {
    public static void main(String[] args) {
        int[] arr={7,3,3,1,3,5};
        int target=3;
        int[] ans=allIndices(0,arr,target,0);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] allIndices(int idx, int[] arr,int target, int count){
        if(idx==arr.length){
            int[] ans=new int[count];
            return ans;
        }
        int[] ans;
        if(arr[idx]==target){
            ans=allIndices(idx+1,arr,target,count+1);
        }
        else{
            ans=allIndices(idx+1,arr,target,count);
        }
        if(arr[idx]==target){
            ans[count]=idx;
        }
        return ans;
    }
}
