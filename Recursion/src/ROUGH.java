import java.util.*;
public class ROUGH {
    public static void main(String[] args) {
        // binary search in rotated sorted array :
        int[] arr = {5,6,7,8,9,10,1,2,3,4};
        int target = 8;
        int start = 0 ;
        int end = arr.length-1;
        System.out.println( binarySearchRotated(arr, target, start, end));

        // subsequence :
        System.out.println("\n Subsequences of `abc` :");
        String str = "abc";
        System.out.println(subString("",str));

        // subsets of array :
        System.out.println("\n SubSets of [1,2,3]:");
        int[] arr1 = {1,2,3};
        System.out.println( subSets( new ArrayList<Integer>(), arr1, 0) );

        // subsets of duplicate value array
        System.out.println("\n Subsets of duplicate value array: [1,2,2] ");
        System.out.println(" for this you need to sort the array first: ");
        int[] arr2 = {1,2,2};
        System.out.println( subSetsInDuplicate( arr2 ) );

        // permutations of string:
        System.out.println("\n Permutations of 'abc' ");
        String s = "abc";
        System.out.println( permutations("" , s) );

        // permutations of array:
        System.out.println("\n Permutations of [1,2,3]");
        int[] arr3 = {1,2,3};
        System.out.println( permutations(new ArrayList<Integer>(),arr3, 0) );

        // phone no. combination
        System.out.println("\n PhonePad combination:");
        String no = "23";
        System.out.println( phonePad( "", no) );
    }
    public static ArrayList<String> phonePad(String p, String up ){
        if( up.length() == 0 ){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        int key = up.charAt(0) - '0';
        int start = (key - 2)*3;
        if( key > 7 ){
            start = start + 1;
        }
        int end = start + 3;
        if( key == 7 || key == 9 ){
            end = end + 1;
        }

        ArrayList<String> ans = new ArrayList<>();
        for( int i = start ; i < end ; i++){
            char ch = (char)( 'a' + i );
            ans.addAll( phonePad(p+ch, up.substring(1)));
        }
        return ans;
    }
    public static ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> p, int[] arr, int idx){
        if( idx == arr.length ){
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        int element = arr[idx];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for( int i = 0 ; i <= p.size() ; i++){
            ArrayList<Integer> temp = new ArrayList<>(p);
            temp.add(i,element);
            ans.addAll( permutations( temp, arr, idx+1 ) );
        }
        return ans;
    }
    public static ArrayList<String> permutations(String p, String up ){
        if( up.length() == 0 ){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0);
        String ss = up.substring(1);

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String last = p.substring(i, p.length());
            ans.addAll( permutations( first+ch+last, ss) );
        }
        return ans;
    }
    public static ArrayList<ArrayList<Integer>> subSetsInDuplicate( int[] arr ){
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> outer =  new ArrayList<>();

        outer.add( new ArrayList<>() );

        int start = 0 ;
        int end = 0 ;

        for (int i = 0; i < arr.length - 1; i++) {
            start = 0;
            if( i > 0 && arr[i] == arr[ i-1 ] ){
                start = end + 1;
            }
            end = outer.size() - 1;
            for (int j = start; j <= end; j++) {
                ArrayList<Integer> list = new ArrayList<>( outer.get(j) );
                list.add( arr[i] );
                outer.add(list);
            }
        }
        return outer;
    }
    public static ArrayList<ArrayList<Integer>> subSets( ArrayList<Integer> p , int[] up , int  idx){
        if( idx == up.length ){
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        int element = up[idx];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        //keep the element:
        ArrayList<Integer> temp = new ArrayList<>(p);
        temp.add(element);
        ans.addAll( subSets( temp, up, idx+1 ) );

        //don't keep the element :
        ans.addAll( subSets( p , up , idx+1 ) );

        return ans;
    }
    public static ArrayList<String> subString(String p , String up ){
        if( up.length() == 0 ){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        char ch = up.charAt(0);
        String ss = up.substring(1);
        ArrayList<String> ans = new ArrayList<>();

        // keep the character:
        ans.addAll( subString(p + ch, ss));

        // skip the character:
        ans.addAll( subString( p, ss));

        return ans;
    }
    public static int binarySearchRotated( int[] arr, int target, int start, int end){
        if( start > end){
            return -1;
        }
        int mid = start + ( end - start )/2;

        if( arr[mid] == target ){
            return mid;
        }
        if( arr[mid] >= arr[start] ){
            if( arr[start] <= target && target < arr[mid] ){
                return binarySearchRotated(arr, target, start, mid-1);
            }
            else{
                return binarySearchRotated(arr, target, mid + 1, end);
            }
        }
        if( arr[mid] <= target && target <= arr[end] ){
            return binarySearchRotated( arr, target, mid+1 , end);
        }else{
            return binarySearchRotated(arr, target, start, mid-1);
        }
    }
}
