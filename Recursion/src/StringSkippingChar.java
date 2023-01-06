public class StringSkippingChar {
    public static void main(String[] args) {
        String s = "baccad";
        StringBuilder builder = new StringBuilder();
        System.out.println(removeA(s));
    }
    public static StringBuilder removeA(String s ){
        if( s.length() == 0 ){
            StringBuilder builder = new StringBuilder();
            return builder;
        }
        char c = s.charAt(0);
        String ss = s.substring(1);
        StringBuilder ansStr = removeA(ss);
        if ( c != 'a' ){
            ansStr.insert(0,c);
        }
        return ansStr;
    }
}
