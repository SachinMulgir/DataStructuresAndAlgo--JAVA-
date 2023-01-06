public class StringSkipString {
    public static void main(String[] args) {
        String s = "godsachingodissachingod";
        String target = "sachin";
        System.out.println(removeString(s,target));
    }
    public static String removeString(String s, String target){
        if( s.length() == 0 ){
            String builder = new String();
            return builder;
        }
        int targetLength = target.length();
        String compareStr = s.substring(0,targetLength);
        String ans = " ";
        if ( compareStr.compareTo(target) == 0 ){
            String ss = s.substring(targetLength);
            ans = removeString(ss,target);
        }
        else{
            String ss= s.substring(1);
            ans = s.charAt(0) + removeString(ss,target);
        }
        return ans;
    }
}
