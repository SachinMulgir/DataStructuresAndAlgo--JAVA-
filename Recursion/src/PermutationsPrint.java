public class PermutationsPrint {
    public static void main(String[] args) {
       permutations("","123");
    }
    static void permutations(String p, String up){
        if( up.isEmpty() ){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        String ss = up.substring(1);

        for( int i = 0; i <= p.length() ; i++){
            String before = p.substring(0, i);
            String after = p.substring(i, p.length());
            permutations(before + ch + after , ss );
        }
    }
}
