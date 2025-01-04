package Q_Hashing;

import java.util.HashSet;

public class H_HashSet {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();// uses HashMap internally
        // add method //O(1)
        hs.add(10);
        hs.add(20);
        hs.add(30);
        System.out.println(hs.add(40));// true
        System.out.println(hs.add(10));// false
        System.out.println(hs);// [40, 10, 20, 30] (random order)
        // remove method //O(1)
        System.out.println(hs.remove(10));// true
        System.out.println(hs.remove(50));// false
        System.out.println(hs);// [40, 20, 30] (random order)
        // contains method//O(1)
        System.out.println(hs.contains(20));// true
        System.out.println(hs.contains(50));// false
        // size method //O(1)
        System.out.println(hs.size());// 3
        // clear method //O(1)
        hs.clear();
        System.out.println(hs.size());// 0
        // isEmpty method //O(1)
        System.out.println(hs.isEmpty());// true

    }
}
