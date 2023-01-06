import java.util.*;
public class arrayCreateTargetArray {
    public static void main(String[] args) {
        //given
        int[] index={0,1,2,3,0};
        int[] nums={1,2,3,4,0};
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>index[i];j--){
                result[j]=result[j-1];
            }
            result[index[i]]=nums[i];
        }
        System.out.println(Arrays.toString(result));
    }
}
