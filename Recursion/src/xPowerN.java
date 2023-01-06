public class xPowerN {
    public static void main(String[] args) {
        int x=2;
        int n=5;
        int ans=power(2,5);
        System.out.println(ans);
    }
    public static int power(int x,int n){
        if(n==0)return 1;
        int sAns=power(x,n-1);
        int ans=x*sAns;
        return ans;
    }
}
