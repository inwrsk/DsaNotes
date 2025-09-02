package Q_Hashing;

import java.util.*;

// Given an integer array of size n, find all elements that appear more than n/3 times.
public class F_MajorityElement {
    public static List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // if the element is already present in the map, increment its count by 1 else
            // put 1
            // getOrDefault returns the value of the key if it is present else returns the
            // default value
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == ((nums.length / 3) + 1)) {
                arr.add(nums[i]);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3 };
        System.out.println(majorityElement(arr));// [3]
    }
}
