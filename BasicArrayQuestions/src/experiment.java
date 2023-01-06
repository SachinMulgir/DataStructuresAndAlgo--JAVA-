import java.util.ArrayList;
import java.util.Arrays;

public class experiment {
    public static void main(String[] args) {

        //EXPERIMENT 1: CHANGING AN INT TO STRING;

//        int[] arr={1,12,123,1234};
//        ArrayList<Integer> list=new ArrayList<>();
//        for(int num:arr){
//            String s="";                      //EMPTY STRING
//            s=s+num;                            //""+1="1" (STRING+NUM)=STRING OF NUM;
//            int numLength=s.length();           //'1'.LENGTH(); //LENGTH OF THE NUM STRING
//            list.add(numLength);                // LENGTH ADDED TO THE LIST.
//        }
//        System.out.println(list);

//        ---------------------------------------------------------------------------------------------------------

        //EXPERIMENT 2:
        int[] nums={3,4,1,9,5};
        int target=5;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
//        ArrayList<Integer> list=new ArrayList<>();
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target<nums[mid]){
                end=mid-1;
            }else if(target>nums[mid]){
                start=mid+1;
            }else if(target==nums[mid]){
//                list.add(mid);
                System.out.println(mid);
            }
        }
//        System.out.println(list);
    }
}
