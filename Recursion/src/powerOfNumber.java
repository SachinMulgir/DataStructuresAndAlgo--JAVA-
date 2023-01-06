public class powerOfNumber {
    public static void main(String[] args) {
        int n=5;
        int x=2;
        System.out.println(power(2,5));    //print 2 raised 5=32;
    }
    public static int power(int x,int n){
        if(n==0)return 1;
        int sAns=power(x,n-1);
        int ans=x*sAns;
        return ans;
    }

}
