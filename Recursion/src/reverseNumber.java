public class reverseNumber {
    public static void main(String[] args) {
        int n=1234;
        System.out.println(reverse(n));
    }
    public static int reverse(int n){
        if(n%10==n)return n;
        int r=n%10;
        int sAns=helper(r,n/10);
        return sAns+reverse(n/10);
    }
    public static int helper(int r,int n){
        int count=0;
        while(n>0){
            n=n/10;
            count++;
        }
        for(int i=0;i<count;i++){
            r=r*10;
        }
        return r;
    }
}
