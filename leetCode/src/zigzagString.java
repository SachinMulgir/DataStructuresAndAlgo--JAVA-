import java.util.*;
//leetCode 6(medium)
//Zigzag conversion
//https://leetcode.com/problems/zigzag-conversion/
//input: String s="PAYPALISHIRING"       and           int numRows=3;
// P   A   H   N
//  A P L S I I G                OUTPUT: P A H N A P L S I I G Y I R    (print row elements)
//   Y   I   R
public class zigzagString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int rows = sc.nextInt();
        //solution
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        for (int j = 0; j < rows; j++) {
            list.add(new ArrayList<Character>());
        }
        int i = 0;
        while (i < str.length()) {
            for (int j = 0; j < rows; j++) {
                if (i < str.length()) list.get(j).add(str.charAt(i++));
            }
            for (int j = rows - 2; j > 0; j--) {
                if (i < str.length()) list.get(j).add(str.charAt(i++));
            }
        }
        String ans = "";
        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < list.get(j).size(); k++) {
                ans = ans + list.get(j).get(k);
            }
        }
        System.out.println(ans);
    }
}
