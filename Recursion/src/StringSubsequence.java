import java.lang.reflect.Array;
import java.util.*;

public class StringSubsequence {
    public static void main(String[] args) {
        String s="abcd";
        ArrayList<String> list=new ArrayList<>();
        subSeq("",s);
        System.out.println();
        list=subSequence(s);
        System.out.println(list);
    }
    public static void subSeq(String p , String up){
        if( up.length() == 0 ){
            System.out.print(p+" ");
            return;
        }
        char ch = up.charAt(0);
        String ss = up.substring(1);
        // Add to ans :
        subSeq(p+ch , ss );
        // skip :
        subSeq( p , ss );
    }
    public static ArrayList<String> subSequence(String s){
        //base case
        if(s.length()==0){
            ArrayList<String> list=new ArrayList<>();
            list.add("");
            return list;
        }

        //store the first char:
        char first_char = s.charAt(0);

        //substring for next recursion call:(smaller substring)
        String ss = s.substring(1);

        ArrayList<String> sAns = subSequence(ss);      //calling function

        ArrayList<String> ans = new ArrayList<>();
        //copy all the elements of sAns
        for(int i = 0 ; i < sAns.size() ; i++){
            ans.add(sAns.get(i));
        }

        //add first_char to each element of sAns and add it to the ans arrayList
        for(int i=0 ; i<sAns.size() ; i++){
            String cAns = first_char + sAns.get(i);
            ans.add(cAns);
        }

        return ans;
    }
}
