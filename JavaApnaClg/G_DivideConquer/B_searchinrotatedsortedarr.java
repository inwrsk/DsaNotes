package G_DivideConquer;

// you are given a sorted array that is rotated at some unknown point. Find the index of target element in the array.
//approch: find the mid element. check if mid is on L1 or L2. if mid is on L1, check if target is in L1. if 
//yes, go left else go right. if mid is on L2, check if target is in L2. if yes, go right else go left.
public class B_searchinrotatedsortedarr {
    public static int search(int arr[], int tar, int si, int ei) {
        if (si > ei) {
            return -1;
        }

        int mid = (si + ei) / 2;
        if (tar == arr[mid]) {
            return mid;
        }

        // mid on L1
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= tar && tar <= arr[mid]) { // go left
                return search(arr, tar, si, mid - 1);
            } else { // go right
                return search(arr, tar, mid + 1, ei);
            }
        }

        // mid on L2
        else {
            if (arr[mid] <= tar && tar <= arr[ei]) { // go right
                return search(arr, tar, mid + 1, ei);
            } else { // go left
                return search(arr, tar, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 1, 2, 3 };
        System.out.println(search(arr, 2, 0, 7));// 5
    }
}
