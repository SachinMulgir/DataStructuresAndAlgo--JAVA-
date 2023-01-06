public class factorial {
    public static void main(String[] args) {
        int n=7;
        System.out.println(fact(n));
    }
    public static int fact(int n){
        if(n==1)return n;
        int ans=n*fact(n-1);
        return ans;
    }
}
