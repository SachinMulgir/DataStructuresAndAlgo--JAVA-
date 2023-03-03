import java.util.*;
public class Q_SubstrWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println("String input:");
        System.out.println("len:");
        int n = sc.nextInt();
        System.out.println("words of equal length:");
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        //solution
        List<Integer> ans = subStrWithAllWords(s,words);
        System.out.println(ans);
    }
    public static boolean checkExcess(Map<String, Integer> shm,Map<String, Integer> thm){
        for( String s : shm.keySet() ){
            if(thm.containsKey(s) == false )return true;
            if( shm.get(s) > thm.get(s) )return true;
        }
        return false;
    }
    public static List<Integer> subStrWithAllWords(String s, String[] words){

        Map<String, Integer> thm = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            thm.put(words[i] , thm.getOrDefault(words[i], 0) + 1);
        }

        int jump = words[0].length();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < jump; i++) {

            Map<String, Integer> shm = new HashMap<>();
            int start = i;
            int end = i;

            while (end + jump <= s.length()) {

                //1. Expansion:
                String sEnd = s.substring(end, end + jump);
                shm.put(sEnd, shm.getOrDefault(sEnd, 0) + 1);
                end += jump;

                //2. Contraction:
                while (start < end && checkExcess(shm, thm)) {
                    String sStart = s.substring(start, start + jump);
                    shm.put(sStart, shm.get(sStart) - 1);
                    if (shm.get(sStart) == 0) {
                        shm.remove(sStart);
                    }
                    start += jump;
                }

                //3. Calculation:
                if (shm.equals(thm)) {
                    ans.add(start);
                }
            }
        }
        return ans;
    }
}
