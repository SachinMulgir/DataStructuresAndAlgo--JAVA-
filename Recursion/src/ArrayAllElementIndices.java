import java.util.*;
public class ArrayAllElementIndices {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,2,8,9};
        int target = 2;

        System.out.println("Three Approaches: ");

        //1.passing the ans ArrayList<Integer> as argument:
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println( "ArrayList as argument: " + allIndices(arr,target,0,list) );

        //2.Creating the ans ArrayList<Integer> inside the function
        //not creating list in every step..just once at the end of array and storing values while coming back.
        System.out.println( "Single ArrayList taking return values: " + allIndices2(arr,target,0));

        //3.Creating the ans ArrayList<Integer> inside the function
        //creating list in every step and joining it with the ans list that is coming back from the end of array
        System.out.println( "New ArrayList at each step: " + allIndices3(arr,target,0));


    }
    public static ArrayList<Integer> allIndices(int[] arr,int target,int idx, ArrayList<Integer> list){
        if(idx == arr.length)return list;
        if(arr[idx] == target)list.add(idx);
        return allIndices(arr,target,idx+1,list);
    }
    public static ArrayList<Integer> allIndices2(int[] arr,int target,int idx){
        if(idx == arr.length){
            ArrayList<Integer> list = new ArrayList<>();
            return list;
        }
        ArrayList<Integer> list = allIndices2(arr,target,idx+1);
        if(arr[idx] == target)list.add(idx);
        return list;
    }
    public static ArrayList<Integer> allIndices3(int[] arr,int target,int idx){
        ArrayList<Integer> list = new ArrayList<>();
        if(idx == arr.length){
            return list;
        }
        if(arr[idx] == target)list.add(idx);
        ArrayList<Integer> ans = allIndices3(arr,target,idx+1);
        list.addAll(ans);
        return list;
    }
}
