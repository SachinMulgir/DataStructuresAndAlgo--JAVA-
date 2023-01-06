import java.util.*;
//744
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/
public class binarySearchCeilingCharacter {
    public static void main(String[] args) {

        char[] letters={'c','f','j'};
        char target='d';
        char ans=nextGreatestLetter(letters,target);
        System.out.println(ans);
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int start=0;
        int end=letters.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(letters[mid]<target){
                start=mid+1;
            }else if(letters[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return letters[start%letters.length];

    }
}
