import java.util.*;
//problem 1295
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class evenNumberDigits {
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
//NOTE:
//HERE WE ARE RUNNING LOOP FOR ACCESSING EACH ELEMENT OF THE ARRAY.
//THEN RUNNING A WHILE LOOP FOR EACH ELEMENT TO CHECK FOR THE NUMBER FOR DIGITS IT IS HAVING
//THEN WE ARE CHECKING THE NO. OF DIGITS ARE EVEN OR NOT. IF EVEN ADD TO THE COUNT OF EVEN DIGIT NUMBERS.
//IN THE END RETURN THE EVEN DIGIT NUMBER COUNT;