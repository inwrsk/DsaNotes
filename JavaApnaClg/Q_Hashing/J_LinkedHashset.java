package Q_Hashing;

import java.util.LinkedHashSet;

public class J_LinkedHashset {
    public static void main(String[] args) {
        // LinkedHashSet maintains the order of insertion
        // all other methods are same as HashSet
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(10);
        lhs.add(30);
        lhs.add(null);
        lhs.add(20);

        System.out.println(lhs);// 10, 30, null, 20]
    }
}
