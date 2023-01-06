import java.util.*;
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class roughWork {
    public static void main(String[] args) {
        int[] arr={12,1234,12345,4346};
        int mainCount=0;
        for(int num: arr){
            int count=0;
            while(num>0){
                num=num/10;
                count++;
            }
            if(count%2==0)mainCount++;
        }
        System.out.println(mainCount);
    }
}
