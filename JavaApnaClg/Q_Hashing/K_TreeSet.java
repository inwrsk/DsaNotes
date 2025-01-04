package Q_Hashing;

import java.util.TreeSet;

public class K_TreeSet {
    public static void main(String[] args) {
        // TreeSet maintains the order of elements
        // all other methods are same as HashSet
        // TreeSet is implemented using Red-Black tree
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(10);
        ts.add(30);
        ts.add(20);
        System.out.println(ts);// [10, 20, 30]
    }
}
