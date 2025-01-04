package Q_Hashing;

import java.util.HashSet;

public class L_UnionAndIntersection {
    static void unionAndIntersection(int nums1[], int nums2[]) {
        HashSet<Integer> Union = new HashSet<>();// add both arrays to this set
        HashSet<Integer> set = new HashSet<>();// add nums1 to this set
        for (int i : nums1) {
            Union.add(i);
            set.add(i);
        }
        for (int i : nums2) {
            Union.add(i);
        }
        System.out.println(Union);
        HashSet<Integer> intersection = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {// add common elements to intersection set
                intersection.add(i);
            }
        }
        System.out.println(intersection);
    }

    public static void main(String[] args) {
        int nums1[] = { 10, 15, 4, 20 };
        int nums2[] = { 8, 4, 2, 10 };
        unionAndIntersection(nums1, nums2);
        // Output:
        // [2, 4, 8, 10, 15, 20]
        // [10, 4]
    }
}
