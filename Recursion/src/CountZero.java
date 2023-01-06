import java.util.*;
public class CountZero {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==0){
            System.out.println(1);
            return;
        }
        System.out.println(zeroCount(n));
        System.out.println(zeroCount2(n,0));
    }
    public static int zeroCount(int n){
        if(n==0)return 0;
        int r=n%10;
        int sAns=zeroCount(n/10);
        if(r==0)sAns++;
        return sAns;
    }
    public static int zeroCount2(int n,int count){
        if(n==0)return count;
        int r=n%10;
        int ans;
        if(r==0){
            ans=zeroCount2(n/10,count+1);
        }
        else{
            ans=zeroCount2(n/10,count);
        }
        return ans;
    }
}
