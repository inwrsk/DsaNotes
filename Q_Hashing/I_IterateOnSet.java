package Q_Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class I_IterateOnSet {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(10);
        hs.add(20);
        hs.add(30);
        hs.add(40);
        // iterate using Iterator
        System.out.println("Iterating using Iterator");
        Iterator it = hs.iterator();// iterator returns an iterator over the elements in this set
        while (it.hasNext()) {
            System.out.print(it.next() + " ");// 20 40 10 30
        }
        // iterate using for-each loop
        System.out.println("\nIterating using for-each loop");
        for (int i : hs) {
            System.out.print(i + " ");// 20 40 10 30
        }
    }
}
