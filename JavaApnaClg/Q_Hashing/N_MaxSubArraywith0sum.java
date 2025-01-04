package Q_Hashing;

import java.util.*;

//we have to find the length of the longest subarray with sum 0
//we will use hashmap to store the sum and its index
//if we find the same sum again then we will find the length of the subarray (current index - previous index)
//we will keep track of the maximum length
public class N_MaxSubArraywith0sum {
    static int maxLen(int arr[]) {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(maxLen(arr));// 5
    }
}
