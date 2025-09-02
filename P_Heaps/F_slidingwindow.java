package P_Heaps;

import java.util.PriorityQueue;

// we have to find the maximum element in the sliding window of size k
// we will use max heap to solve this problem
// the heap contains all elements of the window and some extra elements (which are not in the window and they are not maximum at the moment so no issues)
// if they are maximum they will be removed till we get the maximum element of the window
public class F_slidingwindow {
    // we will create a class elem which will store the value and index of the
    // element
    class elem implements Comparable<elem> {
        int val;
        int ind;

        elem(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }

        // implementing compareTo method to sort on teh basis of value
        public int compareTo(elem e) {
            return e.val - this.val;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<elem> pq = new PriorityQueue<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];// result array
        int start = 1 - k;// initial starting point of the window
        for (int i = 0; i < n; i++) {
            pq.add(new elem(nums[i], i));
            // if the maximum element is out of the window then remove it
            while (pq.peek().ind < start) {
                pq.remove();
            }
            // if the window is formed then add the maximum element to the result
            if (i >= k - 1) {
                res[i - k + 1] = pq.peek().val;
            }
            // move the window
            start++;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        F_slidingwindow obj = new F_slidingwindow();
        int res[] = obj.maxSlidingWindow(arr, k);
        for (int i : res) {
            System.out.print(i + " ");// 3 3 5 5 6 7
        }
    }
}
