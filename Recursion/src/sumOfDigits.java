public class sumOfDigits {
    public static void main(String[] args) {
        int n=13420;
        System.out.println(sumDigit(n));
    }
    public static int sumDigit(int n){
        if(n==0)return 0;                  //for product of digits return 1; OR if(n%10==n)return n;
        int ans=n%10+sumDigit(n/10);    //for product of digits( just replace '+' with '*';
        return ans;
    }
}
