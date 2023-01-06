import java.util.*;
public class peakElement {
    public static void main(String[] args) {
       int[] arr={11,20,12,25,43};
       int ans=peakElementIndex(arr);
        System.out.println(ans);
    }
    public static int peakElementIndex(int[] arr){
        int ans=-1;
        int n=arr.length;
        if(n==1)ans=0;
        if(n>1 && arr[0]>arr[1])ans=0;
        for(int i=1;i<n-1;i++){
            if(ans==-1 && arr[i]>arr[i-1] && arr[i]>arr[i+1])ans=i;
        }
        if(n>1 && ans==-1 && arr[n-1]>arr[n-2])ans=n-1;
        return ans;
    }
}
