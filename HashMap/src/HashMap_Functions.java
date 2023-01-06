import java.util.*;
public class HashMap_Functions {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        // put -> India - 135, China - 200, Pak - 40, US - 20, UK - 15
        hm.put("India" , 135);
        hm.put("China" , 200);
        hm.put("Pak", 40);
        hm.put("US", 20);
        hm.put("UK", 15);
        System.out.println("starting hashmap:");
        System.out.println(hm);

        // add new
        System.out.println("add dubai:");
        hm.put("Dubai", 20);
        System.out.println(hm);
        // update existing
        System.out.println("update pak:");
        hm.put("Pak", 10);

        System.out.println(hm);

        // remove newly added
        System.out.println("remove dubai:");
        hm.remove("Dubai");
        System.out.println(hm);

        // create set of keys:
        System.out.println("keySet using hm.keySet():");
        Set<String> keys = hm.keySet();
        System.out.println(keys);
    }
}
