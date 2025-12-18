package I_ArrayLists;

// check if there is a pair in the sorted array whose sum is equal to the target
// O(n) as we are traversing the array only once

public class F_PairSum {
    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4 };
        Integer target = 8;
        Integer si = 0;
        Integer li = arr.length - 1;
        while (si < li) {
            if (arr[si] + arr[li] > target) {
                li--;
            } else if (arr[si] + arr[li] < target) {
                si++;
            } else {
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }
}
// Time Complexity: O(n)
