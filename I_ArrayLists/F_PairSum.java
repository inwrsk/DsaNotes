package I_ArrayLists;

// check if there is a pair in the sorted array whose sum is equal to the target
//O(n) as we are traversing the array only once
public class F_PairSum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int target = 8;
        int si = 0;
        int li = arr.length - 1;
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
        System.out.print("false");
    }
}
// Time Complexity: O(n)