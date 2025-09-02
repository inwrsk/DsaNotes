package L_Queues;

import java.util.*;

// problem statement: you are given an array and an integer k, you have to find the maximum of each subarray of size k
// example: arr[] = {1, 3, -1, -3, 5, 3, 6, 7}, k = 3
// output: 3 3 5 5 6 7
// explanation: 1 3 -1 => 3, 3 -1 -3 => 3, -1 -3 5 => 5, -3 5 3 => 5, 5 3 6 => 6, 3 6 7 => 7
// approach: we will use deque to solve this problem
// in deque front is the very first element and back is the very last element we inserted

public class K_kSizeSubarray {
    class elem {
        int val;
        int ind;

        elem(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }

    }

    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        // 1. we will create a deque of elem class which will store the value and index
        // of the element
        Deque<elem> dq = new ArrayDeque<>();
        // 2. iterate over the array
        for (int i = 0; i < arr.length; i++) {
            // a. remove the elements from the front of the deque which are out of the
            // window
            if (!dq.isEmpty() && dq.peek().ind < i - k + 1) {
                dq.remove();
            }
            // b. remove the elements from the back of the deque which are less than the
            // current element because they can't be the maximum at any point
            while (!dq.isEmpty() && dq.peekLast().val <= arr[i]) {
                dq.removeLast();
            }
            // c. add the current element to the deque
            dq.add(new elem(arr[i], i));
            // d. for each window of size k, add the maximum element to the result which is
            // the front of the deque
            if (i >= k - 1) {
                res.add(dq.peekFirst().val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        K_kSizeSubarray obj = new K_kSizeSubarray();
        ArrayList<Integer> res = obj.max_of_subarrays(arr, k);
        for (int i : res) {
            System.out.print(i + " ");// 3 3 5 5 6 7
        }
    }
}
