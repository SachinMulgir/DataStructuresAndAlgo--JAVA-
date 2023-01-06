import java.util.*;
// a1 = 1,1,2,2,2,3,5;
// a2 = 1,1,1,2,2,4,5;
// here the minimum is considered as:
// 1 in a1 = 2
// 1 in a2 = 3
// only 2 times 1 will get printed. (similarly for 2 and rest of the elements);
// ans = 1 1 2 2 5
public class Q_GetCommonElements_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            a1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i] = sc.nextInt();
        }
        getCommonElements(a1, a2);
    }
    public static void getCommonElements(int[] a1 , int[] a2){
        HashMap<Integer, Integer> hm = new HashMap<>();         // to store data of A1
        for(int val : a1){
            if( hm.containsKey(val )){
                hm.put(val, hm.get(val) + 1);                   // if present, increment the value
            }else{
                hm.put(val, 1);                                  // new entry
            }
        }
        // iterate through 2nd and if element is present in hashMap, print it
        for( int val : a2 ){
            if( hm.containsKey(val) ){
                System.out.print(val + " ");
                int n = hm.get(val);
                if( n < 2 ){
                    hm.remove(val);
                }
                else{
                    n--;
                    hm.put(val,n);
                }
            }
        }
    }
}
