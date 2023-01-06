import java.util.Arrays;
import java.util.*;
import java.util.Scanner;

public class rough {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        //1st row arraylist
        arr.add(3);
        arr.add(4);
        arr.add(1);
        list.add(arr);
        //2nd row arraylist
        arr1.add(11);
        arr1.add(10);
        arr1.add(14);
        arr1.add(36);
        arr1.add(28);
        list.add(arr1);
        //3rd row arraylist
        arr2.add(65);
        arr2.add(9);
        arr2.add(95);
        arr2.add(45);
        list.add(arr2);

        //LAMBDA FUNCTIONS:

    //  -------------------------------------------------------------------------
        //1.Print list using lambda function:

        list.forEach( (N) -> {System.out.println(N);});
    //  -------------------------------------------------------------------------
        //2.Sort elements of each array in ascending order using lambda function:

        System.out.println();
        for(int i=0;i<list.size();i++){
            Collections.sort(list.get(i), (x,y) -> (x>y?1:-1));
        }
    //  -------------------------------------------------------------------------
        //3.Sort rows upside down according to their sizes(.size()) using lambda function:

        Collections.sort(list, (x,y) -> (x.size()>y.size()? 1:-1));
    //  -------------------------------------------------------------------------
        //




//        for(int i=0;i<list.size();i++){
//            Collections.sort(list.get(i), (x,y) -> (x>y?1:-1));
//        }

        list.forEach( (N) -> {System.out.println(N);});



    }
}
