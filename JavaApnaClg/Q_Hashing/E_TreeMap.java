package Q_Hashing;

import java.util.HashMap;
import java.util.TreeMap;// uses red black tree (similar to AVL trees ) to maintain the order of keys

public class E_TreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 135);
        tm.put("China", 200);
        tm.put("US", 100);
        // TreeMap maintains the order of keys in sorted order
        // all other methods are same as HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 135);
        map.put("China", 200);
        map.put("US", 100);
        System.out.println(tm);// {China=200, India=135, US=100}(sorted order)
        System.out.println(map);// {China=200, US=100, India=135}(random order)

    }
}
