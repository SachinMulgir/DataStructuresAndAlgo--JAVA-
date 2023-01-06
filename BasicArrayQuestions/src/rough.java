import java.util.ArrayList;
import java.util.Arrays;

public class rough {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        int num=0;
        int k=23;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            num=num*10+arr[i];
        }
        num=num+k;
        int temp=num;
        int count=0;
        while(temp>0){
            temp=temp/10;
            count++;
        }
        int[] arr1=new int[count];
        for(int i=count-1;i>=0;i--){
            int r=num%10;
            arr1[i]=r;
            num=num/10;
        }
        for(int i=0;i<count;i++){
            list.add(arr1[i]);
        }
        System.out.println(list);


    }
}
