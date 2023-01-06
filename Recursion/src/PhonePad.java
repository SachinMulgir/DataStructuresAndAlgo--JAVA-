import java.util.ArrayList;

public class PhonePad {
    public static void main(String[] args) {
        phonePad("", "23");
        ArrayList<String> list = phonePadList("", "23");
        System.out.println(list);
    }
    public static void phonePad( String p, String up){
        if( up.length() == 0 ){
            System.out.println(p);
            return;
        }
        int key = up.charAt(0)-'0';
        int start = (key-2)*3;
        int end = (key-1)*3;
        if( key > 7 ){
            start = start + 1;
        }
        if( key == 7 || key == 9 ){
            end = end + 1;
        }
        for( int i = start ; i < end ; i++ ){

            char ch = (char)('a' + i );
            phonePad( p + ch , up.substring(1) );
        }
    }
    public static ArrayList<String> phonePadList( String p, String up){
        if( up.length() == 0 ){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int key = up.charAt(0)-'0';
        int start = (key-2)*3;
        int end = (key-1)*3;
        if( key > 7 ){
            start = start + 1;
        }
        if( key == 7 || key == 9 ){
            end = end + 1;
        }

        ArrayList<String> ans = new ArrayList<>();

        for( int i = start ; i < end ; i++ ){

            char ch = (char)('a' + i );
            ans.addAll(phonePadList( p + ch , up.substring(1) ));
        }
        return ans;
    }
}
