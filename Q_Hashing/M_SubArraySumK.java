package Q_Hashing;

import java.util.HashMap;

//we have to find the number of subarrays with sum k
//we will use hashmap to store the sum and its frequency i.e how many times the sum has occured
//if we find the sum-k in the map then we will increment the count by the frequency of sum-k(i.e we found f+1 new subarrays whose sum is k)
public class M_SubArraySumK {
    public static void main(String[] args) {
        int arr[] = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
        int k = 7;
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // if sum = k then we have found a subarray whose sum is k (which will start
        // from 0th index) so to have a count of 1 we will put 0 in the map i.e we found
        // some subarray whose sum is 0
        // basically the map will have all the sums and how many times we got the sum
        // till the current index
        // till 0th index we have sum 0 and its frequency is 1 (before 0th index sum is
        // 0)
        // till 1st index we have sum 3 and its frequency is 1 (before 1st index sum is
        // 3)
        // till 2nd index we have sum 7 and its frequency is 1 (...)
        // till 3rd index we have sum 10 and its frequency is 1
        // ...
        // we will get to know the subarray of sum k exists when sum till jth index -
        // sum till ith index = k
        // so if we want to know subarray of sum k exists from 0th index to jth index
        // then we should have to find the sum till jth index - sum till 0th index
        // sooo.. its important to have sum till 0th index in the map i.e (0, 1)
        map.put(0, 1);// (sum till 0th index, frequency of sum till 0th index)
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);// 3

    }
}
