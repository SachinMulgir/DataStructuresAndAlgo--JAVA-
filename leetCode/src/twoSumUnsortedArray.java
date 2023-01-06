import java.lang.reflect.Array;
import java.util.*;
public class twoSumUnsortedArray {
    public static void main(String[] args) {
        int[] arr={5,1,2,3,5,1};
        int target=8;
        int n=arr.length;
        int[] ans=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        //solution
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(new ArrayList<Integer>());
            list.get(i).add(arr[i]);
            list.get(i).add(i);
        }
        Collections.sort(list, (x,y) -> x.get(0)>y.get(0)?1:-1);
        int i=0;
        int j=n-1;
        while(i<j){
            int currentSum=list.get(i).get(0)+list.get(j).get(0);
            if(currentSum==target){
                ans[0]=list.get(i).get(1);
                ans[1]=list.get(j).get(1);
            }
            else if(currentSum>target)j--;
            else i++;
        }
        System.out.println(Arrays.toString(ans));
    }
}
