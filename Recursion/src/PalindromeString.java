public class PalindromeString {
    public static void main(String[] args) {
        String s = "abcbak";
        String str = checkPalindrome(s);
        if( s.compareTo(str)==0 ){
            System.out.println("palindrome");
        }else{
            System.out.println("not palindrome");
        }
    }
    public static String checkPalindrome(String s){
        if( s.length() == 0){
            String ans = "";
            return ans;
        }
        char ch = s.charAt(0);
        String ss = s.substring(1);
        String ans = checkPalindrome(ss);
        ans = ans + ch;
        return ans;
    }
}
