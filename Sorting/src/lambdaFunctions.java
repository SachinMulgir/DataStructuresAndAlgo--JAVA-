import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class lambdaFunctions {
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
        System.out.println("Printing Arraylist using lambda function:");
        list.forEach( (N) -> {System.out.println(N);});
        //  -------------------------------------------------------------------------
        //2.Sort elements of each array in ascending order using lambda function:

        System.out.println();
        for(int i=0;i<list.size();i++){
            Collections.sort(list.get(i), (x, y) -> (x>y?1:-1));
        }
        System.out.println("After sorting elements of each row:");
        list.forEach( (N) -> {System.out.println(N);});
        System.out.println();
        //  -------------------------------------------------------------------------
        //3.Sort rows upside down according to their sizes(.size()) using lambda function:

        Collections.sort(list, (x,y) -> (x.size()>y.size()? 1:-1));
        System.out.println("After sorting each row depending on their size:");
        list.forEach( (N) -> {System.out.println(N);});
        System.out.println();
        //  -------------------------------------------------------------------------
        //4.Print all the element of the matrix arraylist into ascending order:






    }
}
