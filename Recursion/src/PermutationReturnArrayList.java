import java.lang.reflect.Array;
import java.util.ArrayList;

public class PermutationReturnArrayList {
    public static void main(String[] args) {
        ArrayList<String> ans = permutations("", "123");
        for( int i = 0 ; i < ans.size() ; i++ ){
            System.out.println(ans.get(i));
        }
    }
    public static ArrayList<String> permutations(String p , String up){
        if( up.length() == 0 ){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        String ss = up.substring(1);

        ArrayList<String> ans = new ArrayList<>();

        for( int i = 0 ; i <= p.length() ; i++ ){
            String before = p.substring(0,i);
            String after = p.substring(i,p.length());
            ans.addAll(permutations(before + ch + after , ss ));
        }
        return ans;
    }
}
