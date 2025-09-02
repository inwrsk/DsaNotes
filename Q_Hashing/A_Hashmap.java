package Q_Hashing;

import java.util.HashMap;

public class A_Hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        // put method
        map.put("df", 30);
        map.put("def", 20);
        map.put("abc", 10);
        System.out.println(map.put("jkl", 40));// null
        System.out.println(map);// {df=30, abc=10, def=20, jkl=40} (map stores in random order not in the order
                                // of insertion or any sorting order)
        // get method
        System.out.println(map.get("abc"));// 10
        System.out.println(map.get("xyz"));// null
        // containsKey method
        System.out.println(map.containsKey("abc"));// true
        System.out.println(map.containsKey("xyz"));// false
        // remove method
        System.out.println(map.remove("abc"));// 10
        System.out.println(map.remove("xyz"));// null
        // keySet method
        System.out.println(map.keySet());// [df, def, jkl]
        // values method
        System.out.println(map.values());// [30, 20, 40]
        // entrySet method
        System.out.println(map.entrySet());// [df=30, def=20, jkl=40]
        // size method
        System.out.println(map.size());// 3
        // clear method (clears the map)
        map.clear();
        System.out.println(map.size());// 0
    }
}
