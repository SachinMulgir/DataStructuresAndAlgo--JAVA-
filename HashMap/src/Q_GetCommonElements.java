import java.util.*;
// a1 = 1,1,2,2,2,3,5;
// a2 = 1,1,1,2,2,4,5;
// ORDER OF A2 IS FOLLOWED:
// ONCE THE ELEMENT IS CHECKED IN HASHMAP WE'LL POP IT TO AVOID DUPLICATE ELEMENT COMPLICATION
// ans = 1 2 5
public class Q_GetCommonElements {
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
        // iterate through 2nd and if element is present in hashMap, print it and remove it from hashmap
        for( int val : a2 ){
            if( hm.containsKey(val) ){
                System.out.print(val + " ");
                hm.remove(val);            // remove the key from hashMap to ignore duplicate complication
            }
        }
    }
}
