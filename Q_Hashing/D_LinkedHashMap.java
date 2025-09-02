package Q_Hashing;

import java.util.LinkedHashMap;//uses doubly linked list to maintain the order of insertion

public class D_LinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 135);
        lhm.put("China", 200);
        lhm.put("US", 100);
        // LinkedHashMap maintains the order of insertion (only difference from HashMap)
        // all other methods are same
        System.out.println(lhm);// {India=135, China=200, US=100}
    }
}
