package I_ArrayLists;

// check if there is a pair in the rotated sorted array whose sum is equal to the target
//O(n) as we are traversing the array only once
public class G_PairSum2 {
    public static void main(String[] args) {
        int[] arr = { 11, 15, 6, 8, 9, 10 };
        int target = 22;
        int si = 0;
        int li = arr.length - 1;
        // finding the pivot element (smallest element in the array)
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                li = i;
                si = i + 1;
                break;
            }
        }
        // li = 1; and si = 2 (15 and 6)
        int n = arr.length;
        while (si != li) {
            int sum = arr[si] + arr[li];
            if (sum == target) {
                System.out.println("true");
                return;
            }
            if (sum > target) {
                // goes to the previous element till 0th index and then goes to the last element
                li = (li + n - 1) % n;
            } else {
                // goes to the next element till the last index and then goes to the 0th index
                si = (si + 1) % n;
            }
        }
        System.out.println("false");
    }
}
